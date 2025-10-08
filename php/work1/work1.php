<!doctype html>
<html lang="ja">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="../css/style.css">

<title>よくわかるPHPの教科書</title>
</head>
<body>
<header>
<h1 class="font-weight-normal">よくわかるPHPの教科書</h1>    
<a href="">戻る</a>
</header>

<main>
<h2>Practice</h2>
<pre>
<?php
    $doc = file_get_contents('./new.txt');
    $coment = htmlspecialchars($_GET['coment'],ENT_QUOTES);
    $doc = $coment.'<br>'.date('G時 i分 s秒').'<hr>'.$doc;
    file_put_contents('./new.txt',$doc);
    readfile('./new.txt');
?>
</pre>
</main>
</body>    
</html>