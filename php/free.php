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
<table border="1">
<?php
for ($i=1; $i < 10 ; $i++): ?>
    <tr>
        <?php for ($j=1; $j < 10 ; $j++): ?>
            <td><?php print($i*$j);?></td>
        <?php endfor; ?>
    </tr>
<?php endfor; ?>
</table>
</pre>
</main>
</body>    
</html>
