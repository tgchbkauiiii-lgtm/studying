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
$xmlTree = simplexml_load_file('https://rssblog.ameba.jp/sim-mah/rss20.xml');
foreach ($xmlTree->channel->item as $item) :?>
・<a href="<?php print($item->link); ?>"><?php print($item->title); ?></a>
<?php endforeach; ?>
</pre>
</main>
</body>    
</html>
