<?php
/* =======================================
   ログイン画面（警告対策＆CSRF なし簡易版）
   ======================================= */
session_start();
require_once 'dbconnect.php';

/* ---------- 1. 配列を必ず初期化 ---------- */
$error = ['login' => ''];

/* ---------- 2. Cookie 自動入力 ---------- */
if (!empty($_COOKIE['email'])) {
    $_POST['email']    = $_COOKIE['email'];
    $_POST['password'] = $_COOKIE['password'];
    $_POST['save']     = 'on';
}

/* ---------- 3. 認証処理 ---------- */
if (!empty($_POST)) {
    $email = trim($_POST['email']    ?? '');
    $pass  = trim($_POST['password'] ?? '');

    if ($email === '' || $pass === '') {
        $error['login'] = 'blank';
    } else {
        $stmt = $db->prepare('SELECT * FROM members WHERE email=? AND password=?');
        $stmt->execute([$email, sha1($pass)]);
        $member = $stmt->fetch();

        if ($member) {
            /* 認証 OK */
            $_SESSION['id']   = $member['id'];
            $_SESSION['time'] = time();

            /* 自動ログイン */
            if (!empty($_POST['save']) && $_POST['save'] === 'on') {
                setcookie('email',    $email, time()+60*60*24*14);
                setcookie('password', $pass,  time()+60*60*24*14);
            }
            header('Location: index.php'); exit();
        } else {
            $error['login'] = 'failed';
        }
    }
}
?>
<!DOCTYPE html><html lang="ja"><head>
<meta charset="UTF-8">
<title>ログインする</title>
<link rel="stylesheet" href="style.css">
</head><body>
<div id="wrap">
  <div id="head"><h1>ログインする</h1></div>

  <div id="content">
    <div id="lead">
      <p>メールアドレスとパスワードを記入してログインしてください。</p>
      <p>入会手続きがまだの方はこちらからどうぞ。</p>
      <p>&raquo; <a href="join/">入会手続きをする</a></p>
    </div>

    <form action="" method="post">
      <dl>
        <dt>メールアドレス</dt>
        <dd>
          <input type="text" name="email" size="35" maxlength="255"
                 value="<?= htmlspecialchars($_POST['email'] ?? '', ENT_QUOTES) ?>">
          <?php if ($error['login'] === 'blank'): ?>
            <p class="error">※ メールアドレスとパスワードを入力してください</p>
          <?php elseif ($error['login'] === 'failed'): ?>
            <p class="error">※ ログインに失敗しました。正しくご記入ください</p>
          <?php endif; ?>
        </dd>

        <dt>パスワード</dt>
        <dd>
          <input type="password" name="password" size="35" maxlength="255"
                 value="<?= htmlspecialchars($_POST['password'] ?? '', ENT_QUOTES) ?>">
        </dd>

        <dt>ログイン情報の記録</dt>
        <dd>
          <label>
            <input type="checkbox" name="save" value="on"
                   <?= (!empty($_POST['save']) && $_POST['save'] === 'on') ? 'checked' : '' ?>>
            次回からは自動的にログインする
          </label>
        </dd>
      </dl>
      <div><input type="submit" value="ログインする"></div>
    </form>
  </div>

  <div id="foot"><small>&copy; mini Twitter</small></div>
</div>
</body></html>
