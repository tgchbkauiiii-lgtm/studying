<?php
session_start();
require('dbconnect.php');

// ログインチェック
if (!isset($_SESSION['id'])) {
    header('Location: login.php');
    exit();
}

// フォームが送信された場合（退会処理）
if ($_SERVER['REQUEST_METHOD'] === 'POST') {
    $member_id = $_SESSION['id'];

    try {
        // トランザクション開始
        $db->beginTransaction();

        // 1. ユーザーの投稿をすべて削除
        $stmt_posts = $db->prepare('DELETE FROM posts WHERE member_id = ?');
        $stmt_posts->execute([$member_id]);

        // 2. ユーザー自身を削除
        $stmt_member = $db->prepare('DELETE FROM members WHERE id = ?');
        $stmt_member->execute([$member_id]);

        // すべての処理が成功したらコミット
        $db->commit();

    } catch (PDOException $e) {
        // エラーが発生したらロールバック
        $db->rollBack();
        die('データベースエラー: ' . $e->getMessage());
    }

    // ログアウト処理 (logout.php より)
    $_SESSION = array();
    if (ini_get("session.use_cookies")) {
        $params = session_get_cookie_params();
        setcookie(session_name(), '', time() - 42000,
            $params["path"], $params["domain"],
            $params["secure"], $params["httponly"]
        );
    }
    session_destroy();

    setcookie('email', '', time()-3600);
    setcookie('password', '', time()-3600);

    // 退会完了ページへリダイレクト
    header('Location: unsubscribed.php');
    exit();
}

?>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>退会手続き</title>
    <link rel="stylesheet" href="style.css" />
</head>
<body>
<div id="wrap">
    <div id="head">
        <h1>退会手続き</h1>
    </div>
    <div id="content">
        <p>退会すると、これまでの投稿もすべて削除され、元に戻すことはできません。</p>
        <p>本当に退会しますか？</p>

        <form action="" method="post">
            <input type="submit" value="退会する">
            <p><a href="index.php">キャンセルして戻る</a></p>
        </form>
    </div>
</div>
</body>
</html>