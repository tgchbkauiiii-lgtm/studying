<?php
session_start();
require_once 'dbconnect.php';

try {
    $stmt   = $db->query('SELECT id, name, picture FROM members ORDER BY id');
    $users  = $stmt->fetchAll(PDO::FETCH_ASSOC);   // ← 常に配列で返る
} catch (PDOException $e) {
    // 失敗しても空配列にして foreach を安全にする
    $users = [];
}
/* ---------- 認証チェック ---------- */
if (!isset($_SESSION['id']) || ($_SESSION['time'] + 3600) < time()) {
    header('Location: login.php'); exit();
}
$_SESSION['time'] = time();

/* ---------- メンバー取得 ---------- */
$me = $db->prepare('SELECT * FROM members WHERE id=?');
$me->execute([$_SESSION['id']]);
$me = $me->fetch(PDO::FETCH_ASSOC);
/* ----------------- 右上プロフィール用ターゲット取得 ----------------- */
/* これを $me を取得したすぐ下あたりに置くと安全 */

$targetId = isset($_GET['to']) ? (int)$_GET['to'] : (int)$_SESSION['id'];

$profileStmt = $db->prepare(
  'SELECT id, name, picture, bio, birthday, hobbies
     FROM members
    WHERE id = ?'
);
$profileStmt->execute([$targetId]);
$target = $profileStmt->fetch(PDO::FETCH_ASSOC);

/* もし無効な ID の場合は自分 ($me) をフォールバック */
if (!$target) {
  $target = $me;             // $me は既に取得済み
  if (!$target['bio']) $target['bio'] = 'プロフィール未登録';
}


/* ---------- 返信リンク処理 ---------- */
$replyPrefill = '';
$replyPostId  = '';
if (isset($_GET['res'])) {
    $r = $db->prepare(
      'SELECT p.message, m.name FROM posts p
        JOIN members m ON m.id = p.member_id
       WHERE p.id = ?'
    );
    $r->execute([$_GET['res']]);
    if ($src = $r->fetch()) {
        $replyPrefill = ">>{$src['name']} さん\n{$src['message']}\n";
        $replyPostId  = $_GET['res'];
    }
}

/* ---------- 投稿処理 ---------- */
if (!empty($_POST['message'])) {
    	$ins = $db->prepare(
  		'INSERT INTO posts SET member_id=?, message=?, reply_post_id=?, created=NOW()'
		);
		$ins->execute([
   	 	$_SESSION['id'],
    	$_POST['message'],
    	$_POST['reply_post_id'] !== '' ? $_POST['reply_post_id'] : null   // ← null を渡す
		]);

    header('Location: index.php'); exit();
}

/* ---------- ページング ---------- */
$page = max(1, (int)($_GET['page'] ?? 1));
$total = $db->query('SELECT COUNT(*) FROM posts')->fetchColumn();
$maxPage = max(1, (int)ceil($total / 5));
$page = min($page, $maxPage);
$start = ($page - 1) * 5;

/* ---------- 投稿一覧を取得して最新5件だけ表示 ---------- */
$allRows = [];   // ← これで未定義エラーを防ぐ

$sql = '
  SELECT p.*, m.name, m.picture
    FROM posts p
    LEFT JOIN members m ON m.id = p.member_id
   ORDER BY p.created ASC'; // 古い順

$postStmt = $db->query($sql);
$rows = $postStmt ? $postStmt->fetchAll(PDO::FETCH_ASSOC) : [];

?>

<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>ミニTwitter レイアウト</title>
  <link rel="stylesheet" href="mainstyle.css">
</head>
<body>
  <!-- 全体を横並びにするコンテナ -->
  <div class="container">
    
    <!-- 左：機能追加ゾーン -->
    <nav class="sidebar">
    <a href="profile.php?id=<?= htmlspecialchars($_SESSION['id']) ?>" class="sidebar-item">プロフィール編集</a>
    <a href="nikoniko.php" class="sidebar-item">chat</a>
    <a href="bot.php" class="sidebar-item" target="_blanl" rel="noopenr noreferrer">bot</a>
    <a href="zosu1/index.html" class="sidebar-item">zosu</a>
    <a href="employee/dosu.html" class="sidebar-item">ドス紹介</a>
    <a href="logout.php" class="sidebar-item">ログアウト</a>
    <a href="unsubscribe.php" class="sidebar-item">退会する</a>
      <!-- 必要に応じてリンクを追加 -->
    </nav>
    
    <!-- 左中央：アカウント一覧 -->
    <div class="account-list">
      <!-- PHPでループしてアカウントを表示 -->
      <?php foreach ($users as $u): ?>
<a href="index.php?to=<?= htmlspecialchars($u['id']) ?>" class="user-item">
  <img src="member_picture/<?= htmlspecialchars($u['picture']) ?>"
       alt=""
       width="32" height="32">
  <span><?= htmlspecialchars($u['name']) ?><br></span>
</a>
<?php endforeach; ?>
    </div>

    <!-- 左下：自分のアカウント表示 -->
    <div class="my-account-box">
      <img src="member_picture/<?= htmlspecialchars($me['picture'] ?? 'default.png') ?>" alt="自分のアイコン" width="40" height="40" class="my-account-icon">
      <span class="my-account-name"><?= htmlspecialchars($me['name']) ?></span>
    </div>

    <!-- 右：メイン領域 -->
    <main class="main-area">
      
      <!-- プロフィールエリア -->
<!-- プロフィールエリア -->
<section class="profile-area">
  <!-- 左：大きなアイコン -->
  <img
    src="member_picture/<?= htmlspecialchars($target['picture'] ?? 'default.png') ?>"
    alt="<?= htmlspecialchars($target['name']) ?> のアバター"
    class="avatar-lg profile-modal-trigger"
    width="80"
    height="80"
    style="cursor:pointer;"
  >

  <!-- 右：名前＋プロフィール -->
  <div class="profile-box">
    <h2 class="username-lg">
      <?= htmlspecialchars($target['name']) ?>
      <?php
        // 誕生日表示
        if (!empty($target['birthday'])) {
          $b = date('Y年n月j日', strtotime($target['birthday']));
          echo '<span style="font-size:0.7em; color:#888; margin-left:10px;">🎂 生年月日 ' . htmlspecialchars($b) . '</span>';
        }
        // 趣味表示
        if (!empty($target['hobbies'])) {
          echo '<span style="font-size:0.7em; color:#888; margin-left:10px;">🎵 趣味 ' . htmlspecialchars($target['hobbies']) . '</span>';
        }
      ?>
    </h2>
    <p class="profile-bio">
      <?= nl2br(htmlspecialchars($target['bio'] ?? 'プロフィール未登録')) ?>
    </p>
  </div>
</section>

<!-- プロフィール拡大モーダル -->
<div id="profile-modal" class="profile-modal" style="display:none;">
  <div class="profile-modal-content">
    <span class="profile-modal-close" style="cursor:pointer;position:absolute;top:10px;right:20px;font-size:2em;">&times;</span>
    <img
      src="member_picture/<?= htmlspecialchars($target['picture'] ?? 'default.png') ?>"
      alt="<?= htmlspecialchars($target['name']) ?> のアバター"
      style="width:180px;height:180px;border-radius:50%;display:block;margin:0 auto 20px;"
    >
    <h2 style="text-align:center;"><?= htmlspecialchars($target['name']) ?></h2>
    <?php if (!empty($target['birthday'])): ?>
      <p style="text-align:center;">🎂 生年月日 <?= htmlspecialchars(date('Y年n月j日', strtotime($target['birthday']))) ?></p>
    <?php endif; ?>
    <?php if (!empty($target['hobbies'])): ?>
      <p style="text-align:center;">🎵 趣味 <?= htmlspecialchars($target['hobbies']) ?></p>
    <?php endif; ?>
    <p style="text-align:center;white-space:pre-line;"> <?= nl2br(htmlspecialchars($target['bio'] ?? 'プロフィール未登録')) ?> </p>
  </div>
</div>

<style>
.profile-modal {
  position: fixed;
  z-index: 9999;
  left: 0; top: 0; width: 100vw; height: 100vh;
  background: rgba(0,0,0,0.6);
  display: flex; align-items: center; justify-content: center;
}
.profile-modal-content {
  background: #fff;
  padding: 40px 30px 30px 30px;
  border-radius: 16px;
  min-width: 320px;
  max-width: 90vw;
  position: relative;
  box-shadow: 0 4px 24px rgba(0,0,0,0.2);
}
.profile-modal-close {
  position: absolute;
  top: 10px;
  right: 20px;
  color: #888;
  font-size: 2em;
  cursor: pointer;
}
.my-account-box {
  position: fixed;
  left: 20px;
  bottom: 20px;
  display: flex;
  align-items: center;
  background: #fff;
  border-radius: 24px;
  box-shadow: 0 2px 8px rgba(0,0,0,0.08);
  padding: 8px 16px 8px 8px;
  z-index: 10000;
  min-width: 120px;
}
.my-account-icon {
  border-radius: 50%;
  margin-right: 10px;
  border: 1px solid #eee;
}
.my-account-name {
  font-weight: bold;
  color: #333;
  font-size: 1.1em;
}
@media (max-width: 600px) {
  .my-account-box {
    left: 5px;
    bottom: 5px;
    padding: 4px 8px 4px 4px;
  }
  .my-account-name {
    font-size: 0.95em;
  }
}
</style>

      <div class="chat-wrapper">              <!-- ① ラッパー開始 -->
      <!-- DMエリア -->
      <section class="dm-area">
        <div class="message-history">
        <?php echo '<!-- 投稿件数: ' . count($rows) . ' -->'; ?>
        <?php foreach ($rows as $row): ?>
  <div class="msg" id="post<?= $row['id'] ?>">
    <div class="msg-header">
      <img src="member_picture/<?= htmlspecialchars($row['picture']) ?>" alt="" width="48" height="48">
      <span class="msg-name"><?= htmlspecialchars($row['name']) ?></span>
      <span class="msg-date"><?= htmlspecialchars($row['created']) ?></span>
      <a href="view.php?id=<?= $row['id'] ?>">詳細</a>
      <a href="index.php?res=<?= $row['id'] ?>#form">返信</a>
      <?php if ($row['member_id'] == $_SESSION['id']): ?>
        <a href="delete.php?id=<?= $row['id'] ?>" onclick="return confirm('削除しますか？');">削除</a>
      <?php endif; ?>
    </div>
    <div class="msg-body">
      <?= nl2br(htmlspecialchars($row['message'])) ?>
    </div>
  </div>
<?php endforeach; ?>
        </div>
        <!-- 送信フォーム（最下端に固定） -->
        <form class="message-form" id="form" action="" method="post">
          <textarea name="message" rows="2" placeholder="メッセージを入力…" required><?= htmlspecialchars($replyPrefill . ($_POST['message'] ?? ''), ENT_QUOTES) ?></textarea>
          <input type="hidden" name="reply_post_id" value="<?= htmlspecialchars($replyPostId ?: ($_POST['reply_post_id'] ?? '')) ?>">
          <button type="submit">送信</button>
        </form>
      </section>
      </div>                                   <!-- ② ラッパー終了 -->
      
    </main>
  </div>
  <script>
window.addEventListener('load', () => {
  const hist = document.querySelector('.message-history');
  if (hist) hist.scrollTop = hist.scrollHeight;

  // Enterで送信、Shift+Enterで改行
  const textarea = document.querySelector('.message-form textarea');
  const form = document.querySelector('.message-form');
  if (textarea && form) {
    textarea.addEventListener('keydown', function(e) {
      if (e.key === 'Enter' && !e.shiftKey) {
        e.preventDefault();
        form.submit();
      }
    });
  }

  // プロフィール画像クリックでモーダル表示
  const modal = document.getElementById('profile-modal');
  const trigger = document.querySelector('.profile-modal-trigger');
  const closeBtn = document.querySelector('.profile-modal-close');
  if (trigger && modal && closeBtn) {
    trigger.addEventListener('click', () => {
      modal.style.display = 'flex';
    });
    closeBtn.addEventListener('click', () => {
      modal.style.display = 'none';
    });
    modal.addEventListener('click', (e) => {
      if (e.target === modal) modal.style.display = 'none';
    });
  }
});


    // setInterval(() => {
    //     location.reload();
    // }, 10000);
</script>


</body>
</html>
