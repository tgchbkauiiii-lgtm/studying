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
<h2>Practice</h2>
<pre>
<?php
for ($i=100; $i>0;$i--) {
    print("$i\n");
    $i--; 
    # code...
}
for ($j=1; $j < 1000 ; $j=$j*2) { 
    print("$j\n");
}
?>
<?php
for ($k=0; $k <=5 ; $k++): ?>
    こんにちは
<?php endfor; ?>
</pre>
</main>
</body>    
</html>
