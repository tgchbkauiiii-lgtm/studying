<!doctype html>
<html lang="ja">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="css/style.css">

<title>よくわかるPHPの教科書</title>
</head>
<body>
<header>
<h1 class="font-weight-normal">よくわかるPHPの教科書</h1>    
</header>

<main>
<h2>別のぺージにジャンプする</h2>
<pre>
<?php
   header('Location: https://www.yahoo.co.jp/');
   exit();
?>
<!-- doctype宣言よりも前、一番上に置くのが望ましい -->
</pre>
</main>
</body>    
</html>