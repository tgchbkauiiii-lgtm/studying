<?php
// セッション開始＆DB接続
session_start();
require_once '../dbconnect.php';

// エラー情報を格納する配列を初期化
$errors = [];

// 「書き直す」リンクで戻ってきたとき、前回の入力値を復元
if (($_GET['action'] ?? '') === 'rewrite' && isset($_SESSION['join'])) {
    $_POST = $_SESSION['join'];
}

// フォームが送信されたとき（確認画面へ遷移）
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    // ----- 1. 必須チェック -----
    if (trim($_POST['name']     ?? '') === '') $errors['name']     = 'blank';
    if (trim($_POST['email']    ?? '') === '') $errors['email']    = 'blank';
    if (trim($_POST['password'] ?? '') === '') {
        $errors['password'] = 'blank';
    } elseif (strlen($_POST['password']) < 4) {
        $errors['password'] = 'length';
    }

    // ----- 2. 画像チェック -----
    // 新規アップロード時
    if (!empty($_FILES['image']['name']) && $_FILES['image']['error'] === UPLOAD_ERR_OK) {
        $ext = strtolower(pathinfo($_FILES['image']['name'], PATHINFO_EXTENSION));
        if (!in_array($ext, ['jpg','gif','png'], true)) {
            $errors['image'] = 'type';
        }
    }
    // 書き直しモードでセッションに画像が残っていればOK
    if (empty($_FILES['image']['name']) && empty($_POST['image']) && !isset($errors['image'])) {
        // 画像選択なし＆セッションにも無ければエラーにしたい場合はここで設定
        // $errors['image'] = 'blank';
    }

    // ----- 3. メール重複チェック -----
    if (empty($errors)) {
        $stmt = $db->prepare('SELECT COUNT(*) FROM members WHERE email=?');
        $stmt->execute([$_POST['email']]);
        if ($stmt->fetchColumn() > 0) {
            $errors['email'] = 'duplicate';
        }
    }

    // ----- 4. エラーなければ画像保存＆確認画面へ -----
    if (empty($errors)) {
        // ファイル名決定＆移動
        if (!empty($_FILES['image']['name']) && $_FILES['image']['error'] === UPLOAD_ERR_OK) {
            $filename = date('YmdHis') . '_' . bin2hex(random_bytes(4)) . '.' . $ext;
            move_uploaded_file(
                $_FILES['image']['tmp_name'],
                __DIR__ . '/../member_picture/' . $filename
            );
        } else {
            // 書き直しモードで既存画像があれば継承
            $filename = $_POST['image'] ?? '';
        }

        // セッションに登録データを格納
        $_SESSION['join'] = [
            'name'     => $_POST['name'],
            'email'    => $_POST['email'],
            'password' => $_POST['password'],
            'image'    => $filename,
        ];
        // 確認画面へリダイレクト
        header('Location: check.php');
        exit();
    }
}
?>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
  <title>会員登録</title>
  <!-- join フォルダ → 1 つ上の階層にある style.css を読み込む -->
  <link rel="stylesheet" href="../style.css">
</head>
<body>
  <div id="wrap">
    <div id="head"><h1>会員登録</h1></div>
    <div id="content">
      <p>以下のフォームに必要事項を記入し、「確認画面へ」ボタンをクリックしてください。</p>
      <form action="" method="post" enctype="multipart/form-data">
        <dl>
          <!-- ニックネーム -->
          <dt>ニックネーム</dt>
          <dd>
            <?php if (isset($errors['name']) && $errors['name'] === 'blank'): ?>
              <p class="error">ニックネームを入力してください</p>
            <?php endif; ?>
            <input 
              type="text" name="name" size="35" maxlength="255"
              value="<?php echo htmlspecialchars($_POST['name'] ?? '', ENT_QUOTES); ?>"
            >
          </dd>

          <!-- メールアドレス -->
          <dt>メールアドレス</dt>
          <dd>
            <?php if (isset($errors['email'])): ?>
              <?php if ($errors['email'] === 'blank'): ?>
                <p class="error">メールアドレスを入力してください</p>
              <?php elseif ($errors['email'] === 'duplicate'): ?>
                <p class="error">このメールアドレスはすでに登録されています</p>
              <?php endif; ?>
            <?php endif; ?>
            <input 
              type="email" name="email" size="35" maxlength="255"
              value="<?php echo htmlspecialchars($_POST['email'] ?? '', ENT_QUOTES); ?>"
            >
          </dd>

          <!-- パスワード -->
          <dt>パスワード</dt>
          <dd>
            <?php if (isset($errors['password'])): ?>
              <?php if ($errors['password'] === 'blank'): ?>
                <p class="error">パスワードを入力してください</p>
              <?php elseif ($errors['password'] === 'length'): ?>
                <p class="error">パスワードは4文字以上で入力してください</p>
              <?php endif; ?>
            <?php endif; ?>
            <input 
              type="password" name="password" size="10" maxlength="20"
              value="<?php echo htmlspecialchars($_POST['password'] ?? '', ENT_QUOTES); ?>"
            >
          </dd>

          <!-- 写真など -->
          <dt>写真など</dt>
          <dd>
            <?php if (isset($errors['image']) && $errors['image'] === 'type'): ?>
              <p class="error">画像は jpg/gif/png のいずれかでアップロードしてください</p>
            <?php endif; ?>
            <input type="file" name="image">

            <?php if (!empty($_POST['image'])): // 書き直しで既存画像がある場合 ?>
              <p>（再選択しなければ前回アップロード分が使用されます）</p>
              <img 
                src="/post/member_picture/<?php echo htmlspecialchars($_POST['image'], ENT_QUOTES); ?>"
                width="100" height="100" alt="プレビュー">
              <!-- 前回の画像名を隠しフィールドで保持 -->
              <input type="hidden" name="image" value="<?php echo htmlspecialchars($_POST['image'], ENT_QUOTES); ?>">
            <?php endif; ?>
          </dd>
        </dl>

        <div>
          <input type="submit" value="確認画面へ">
        </div>
      </form>
    </div><!-- /#content -->
  </div><!-- /#wrap -->
</body>
</html>
