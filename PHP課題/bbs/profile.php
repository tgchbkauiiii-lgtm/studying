<?php
session_start();
require_once 'dbconnect.php'; // index.phpと同じ接続方法を使う

/* ---------- 認証チェック（必須） ---------- */
if (!isset($_SESSION['id']) || ($_SESSION['time'] + 3600) < time()) {
    header('Location: login.php');
    exit();
}
$_SESSION['time'] = time();

/* ---------- 表示対象のユーザーIDを決定 ---------- */
$profile_id = isset($_GET['id']) ? (int)$_GET['id'] : $_SESSION['id'];

/* ---------- 権限チェック ---------- */
$is_my_profile = ($profile_id === (int)$_SESSION['id']);


/* ★★★ フォームが送信された（POSTリクエスト）場合の処理 ★★★ */
if ($_SERVER['REQUEST_METHOD'] === 'POST' && $is_my_profile) {
    // 自分自身のプロフィールを編集しようとしている時だけ、更新処理を行う

    // 1. 更新するカラムと値を準備する配列
    $update_columns = [];
    $update_params = [];

    // 2. 各フォーム項目の値を取得して、更新リストに追加
    // (name, email, bio, birthday, hobbies)
    $update_columns['name'] = $_POST['username'] ?? '';
    $update_columns['email'] = $_POST['email'] ?? '';
    $update_columns['bio'] = $_POST['bio'] ?? '';
    $update_columns['birthday'] = !empty($_POST['birthday']) ? $_POST['birthday'] : null;
    $hobbies_array = $_POST['hobbies'] ?? [];
    $update_columns['hobbies'] = implode(',', $hobbies_array);

    // 3. パスワードの更新処理 (入力があった場合のみ)
    if (!empty($_POST['password'])) {
        // パスワードは必ずハッシュ化して安全に保存
        $update_columns['password'] = password_hash($_POST['password'], PASSWORD_DEFAULT);
    }

    // 4. 画像の更新処理 (ファイルアップロードがあった場合のみ)
    if (isset($_FILES['picture']) && $_FILES['picture']['error'] === UPLOAD_ERR_OK) {
        $file = $_FILES['picture'];
        $ext = pathinfo($file['name'], PATHINFO_EXTENSION);
        // 安全なファイル名（ユニークなID + 拡張子）を生成
        $new_file_name = sha1(uniqid(mt_rand(), true)) . '.' . $ext;
        $file_path = 'member_picture/' . $new_file_name;

        // 指定ディレクトリにファイルを移動
        if (move_uploaded_file($file['tmp_name'], $file_path)) {
            $update_columns['picture'] = $new_file_name;
        }
    }

    // 5. UPDATE文を動的に構築して実行
    if (!empty($update_columns)) {
        $set_clauses = [];
        foreach ($update_columns as $column_name => $value) {
            $set_clauses[] = "$column_name = ?";
            $update_params[] = $value;
        }
        $set_string = implode(', ', $set_clauses);

        // WHERE句で使うIDをパラメータの最後に追加
        $update_params[] = $profile_id;
        
        $sql = "UPDATE members SET $set_string WHERE id = ?";
        $stmt = $db->prepare($sql);
        $stmt->execute($update_params);
    }

    // 自分のプロフィールページにリダイレクトして変更を反映
    header('Location: profile.php?id=' . $profile_id);
    exit();
}


/* ---------- ページを表示するためのデータ取得（GETリクエスト） ---------- */
// 編集に必要な項目を全て取得
$stmt = $db->prepare("SELECT name, email, bio, birthday, picture, hobbies FROM members WHERE id = ?");
$stmt->execute([$profile_id]);
$user = $stmt->fetch(PDO::FETCH_ASSOC);

if (!$user) {
    die("指定されたIDのユーザーが見つかりません。");
}

// 趣味を文字列から配列に変換
$user_hobbies = !empty($user['hobbies']) ? explode(',', $user['hobbies']) : [];

// 全趣味のリスト
$all_hobbies_list = ['おひるね', 'おやつ', 'おえかき', '読書', 'ゲーム', '歌うこと'];

?>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title><?= htmlspecialchars($user['name']) ?>さんのプロフィール</title>
    <!-- CSSは変更なし（元のコードをそのまま使用） -->
    <style>
        @import url('https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@400;700;800&display=swap');
        :root { --cream-bg: #FFFBF0; --soft-pink: #FFCDEA; --soft-mint: #C8F5E1; --cream-yellow: #FFF8B8; --text-color: #5c544b; --border-color: #e0d9cb; }
        body { font-family: 'M PLUS Rounded 1c', sans-serif; background-color: var(--cream-bg); color: var(--text-color); display: flex; justify-content: center; align-items: center; min-height: 100vh; margin: 0; padding: 20px; box-sizing: border-box; background-image: radial-gradient(circle at 15% 85%, var(--soft-pink) 50px, transparent 51px), radial-gradient(circle at 80% 20%, var(--soft-mint) 70px, transparent 71px), radial-gradient(circle at 90% 90%, var(--cream-yellow) 40px, transparent 41px); }
        .profile-card { background-color: white; border-radius: 30px; padding: 40px; text-align: center; width: 100%; max-width: 400px; box-shadow: 0 10px 25px rgba(0, 0, 0, 0.08), 0 0 0 4px white, 0 0 0 8px var(--soft-pink); position: relative; overflow: hidden; }
        .profile-picture { width: 120px; height: 120px; border-radius: 50%; border: 6px solid var(--soft-mint); object-fit: cover; margin-bottom: 20px; box-shadow: 0 4px 10px rgba(0,0,0,0.1); }
        .username { font-size: 26px; font-weight: 800; margin: 0 0 10px 0; color: #4a423a; }
        .bio { font-size: 16px; line-height: 1.6; margin: 0 0 25px 0; max-width: 300px; margin-left: auto; margin-right: auto; }
        .user-details { list-style: none; padding: 0; margin: 0 0 30px 0; text-align: left; display: flex; flex-direction: column; gap: 15px; }
        .user-details li { display: flex; align-items: center; background-color: #f9f7f2; padding: 12px 15px; border-radius: 15px; border: 2px solid var(--border-color); }
        .user-details .icon { width: 24px; height: 24px; margin-right: 15px; flex-shrink: 0; }
        .user-details .detail-label { font-weight: 700; margin-right: 8px; }
        .edit-button { background-color: var(--soft-pink); color: var(--text-color); border: none; border-radius: 50px; padding: 12px 25px; font-size: 16px; font-weight: 700; cursor: pointer; transition: transform 0.2s ease, box-shadow 0.2s ease; display: inline-flex; align-items: center; gap: 8px; box-shadow: 0 4px 0px #d1a9b9; }
        .edit-button:hover { transform: translateY(-2px) scale(1.05); box-shadow: 0 6px 0px #d1a9b9; }
        .edit-button:active { transform: translateY(2px); box-shadow: 0 2px 0px #d1a9b9; }
        .edit-button .icon { width: 20px; height: 20px; }
        .modal-overlay { position: fixed; top: 0; left: 0; width: 100%; height: 100%; background-color: rgba(92, 84, 75, 0.5); display: flex; justify-content: center; align-items: flex-start; opacity: 0; visibility: hidden; transition: opacity 0.3s ease, visibility 0.3s ease; z-index: 1000; overflow-y: auto; padding: 5vh 20px; }
        .modal-overlay.active { opacity: 1; visibility: visible; }
        .modal-content { background-color: white; padding: 30px; border-radius: 25px; max-width: 450px; width: 90%; box-shadow: 0 10px 30px rgba(0, 0, 0, 0.15); transform: scale(0.9); transition: transform 0.3s ease; }
        .modal-overlay.active .modal-content { transform: scale(1); }
        .modal-header { display: flex; justify-content: space-between; align-items: center; margin-bottom: 20px; }
        .modal-header h2 { margin: 0; font-size: 22px; font-weight: 800; }
        .close-button { background: none; border: none; font-size: 30px; font-weight: 700; color: #aaa; cursor: pointer; line-height: 1; }
        .profile-form .form-group { margin-bottom: 20px; }
        .profile-form label { display: block; font-weight: 700; margin-bottom: 8px; }
        .profile-form input[type="text"], .profile-form input[type="email"], .profile-form input[type="password"], .profile-form input[type="date"], .profile-form textarea { width: 100%; padding: 12px; border: 2px solid var(--border-color); border-radius: 12px; font-family: 'M PLUS Rounded 1c', sans-serif; font-size: 16px; box-sizing: border-box; transition: border-color 0.2s; }
        .profile-form input:focus, .profile-form textarea:focus { outline: none; border-color: var(--soft-pink); }
        .profile-form textarea { resize: vertical; min-height: 80px; }
        .hobbies-group { display: grid; grid-template-columns: 1fr 1fr; gap: 10px; }
        .hobby-item { display: flex; align-items: center; background-color: #f9f7f2; padding: 10px; border-radius: 10px; cursor: pointer; }
        .hobby-item input[type="checkbox"] { margin-right: 10px; }
        .form-actions { text-align: right; }
        .save-button { background-color: var(--soft-mint); color: var(--text-color); border: none; border-radius: 50px; padding: 12px 25px; font-size: 16px; font-weight: 700; cursor: pointer; transition: transform 0.2s ease, box-shadow 0.2s ease; box-shadow: 0 4px 0px #a1c7b5; }
        .save-button:hover { transform: translateY(-2px) scale(1.05); box-shadow: 0 6px 0px #a1c7b5; }
        .save-button:active { transform: translateY(2px); box-shadow: 0 2px 0px #a1c7b5; }
        .back-link { display: inline-block; margin-top: 20px; padding: 10px 20px; background-color: #f0f0f0; color: var(--text-color); text-decoration: none; border-radius: 50px; font-weight: 700; }
    </style>
</head>
<body>

    <div class="profile-card">
        <!-- プロフィール表示 -->
        <img src="member_picture/<?= htmlspecialchars($user['picture'] ?: 'default.png') ?>" alt="プロフィール画像" class="profile-picture">
        <h1 class="username"><?= htmlspecialchars($user['name']) ?></h1>
        <p class="bio"><?= nl2br(htmlspecialchars($user['bio'])) ?></p>

        <!-- ★★★ 省略されていた表示部分を完全な形に ★★★ -->
        <ul class="user-details">
            <li>
                <svg class="icon" viewBox="0 0 24 24" fill="currentColor" xmlns="http://www.w3.org/2000/svg"><path d="M17 12h-5v5h5v-5zM16 1v2H8V1H6v2H5c-1.11 0-1.99.9-1.99 2L3 19c0 1.1.89 2 2 2h14c1.1 0 2-.9 2-2V5c0-1.1-.9-2-2-2h-1V1h-2zm3 18H5V8h14v11z"/></svg>
                <span class="detail-label">おたんじょうび：</span> 
                <?= !empty($user['birthday']) ? date('n月j日', strtotime($user['birthday'])) : '未設定' ?>
            </li>
            <li>
                <svg class="icon" viewBox="0 0 24 24" fill="currentColor" xmlns="http://www.w3.org/2000/svg"><path d="M12 3l-1.45 4.55L6 9l4.5 3.55L9.05 18 12 15.3l2.95 2.7L13.5 12.55 18 9l-4.55-1.45z"/></svg>
                <span class="detail-label">しゅみ：</span> 
                <?= !empty($user['hobbies']) ? htmlspecialchars($user['hobbies']) : '未設定' ?>
            </li>
        </ul>

        <!-- 権限チェック：自分のプロフィールの場合のみ編集ボタンを表示 -->
        <?php if ($is_my_profile): ?>
            <button class="edit-button" id="edit-profile-btn">プロフィールを編集</button>
        <?php endif; ?>

        <a href="index.php" class="back-link">メインページに戻る</a>
    </div>

    <!-- 権限チェック：自分のプロフィールの場合のみ編集モーダルを表示 -->
    <?php if ($is_my_profile): ?>
    <div class="modal-overlay" id="edit-modal">
        <div class="modal-content">
            <div class="modal-header">
                <h2>プロフィールを編集する</h2>
                <button class="close-button" id="close-modal-btn">×</button>
            </div>
            
            <!-- ★★★ 省略されていたフォームを完全な形に ★★★ -->
            <!-- ファイルを送信するため enctype="multipart/form-data" が必須 -->
            <form class="profile-form" id="profile-form" method="POST" action="profile.php?id=<?= $profile_id ?>" enctype="multipart/form-data">
                
                <div class="form-group">
                    <label for="picture-input">プロフィール画像</label>
                    <input type="file" id="picture-input" name="picture" accept="image/jpeg, image/png, image/gif">
                    <small>現在の画像: <?= htmlspecialchars($user['picture']) ?></small>
                </div>

                <div class="form-group">
                    <label for="username-input">ユーザー名</label>
                    <input type="text" id="username-input" name="username" value="<?= htmlspecialchars($user['name']) ?>" required>
                </div>

                <div class="form-group">
                    <label for="email-input">メールアドレス</label>
                    <input type="email" id="email-input" name="email" value="<?= htmlspecialchars($user['email']) ?>" required>
                </div>

                <div class="form-group">
                    <label for="password-input">新しいパスワード</label>
                    <input type="password" id="password-input" name="password" placeholder="変更する場合のみ入力">
                </div>

                <div class="form-group">
                    <label for="bio-input">自己紹介</label>
                    <textarea id="bio-input" name="bio"><?= htmlspecialchars($user['bio']) ?></textarea>
                </div>

                <div class="form-group">
                    <label for="birthday-input">誕生日</label>
                    <input type="date" id="birthday-input" name="birthday" value="<?= htmlspecialchars($user['birthday']) ?>">
                </div>

                <div class="form-group">
                    <label>趣味</label>
                    <div class="hobbies-group">
                        <?php foreach ($all_hobbies_list as $hobby): ?>
                            <label class="hobby-item">
                                <input type="checkbox" name="hobbies[]" value="<?= htmlspecialchars($hobby) ?>" 
                                    <?= in_array($hobby, $user_hobbies) ? 'checked' : '' ?>>
                                <?= htmlspecialchars($hobby) ?>
                            </label>
                        <?php endforeach; ?>
                    </div>
                </div>

                <div class="form-actions">
                    <button type="submit" class="save-button">保存する</button>
                </div>
            </form>
        </div>
    </div>
    <?php endif; ?>

    <!-- JavaScriptは変更なし -->
    <script>
      const editProfileBtn = document.getElementById('edit-profile-btn');
      if (editProfileBtn) {
        const editModal = document.getElementById('edit-modal');
        const closeModalBtn = document.getElementById('close-modal-btn');
        const openModal = () => editModal.classList.add('active');
        const closeModal = () => editModal.classList.remove('active');
        editProfileBtn.addEventListener('click', openModal);
        closeModalBtn.addEventListener('click', closeModal);
        editModal.addEventListener('click', (event) => { if (event.target === editModal) closeModal(); });
      }
    </script>
</body>
</html>