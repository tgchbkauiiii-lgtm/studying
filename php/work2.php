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
<h2>2025年6月のカレンダー</h2>
<pre>
<table>
<?php
   $week = ['日','月', '火', '水', '木', '金', '土'];
   for ($i = 0; $i <= 29; $i++) {
      print(($i+1).'日('.$week[$i%7].')<br />');
   }
?>
</table>
</pre>
</main>
</body>    
</html>