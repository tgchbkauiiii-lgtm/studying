<!doctype html>
<html lang="ja">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->

<title>じゃんけん</title>
</head>
<body>
<header>
</header>

<main>
<pre>
あなた：<?php 
$janken = ['ぐー','ちょき','ぱー'];
$mine = htmlspecialchars($_POST['mine'],ENT_QUOTES);
print($janken[$mine]); ?>
<br>
コンピューター1：<?php $num1 = rand(0,2);
print($janken[$num1]);
?><br>
コンピューター2：<?php $num2 = rand(0,2);
print($janken[$num2]);
?><br>
<?php



$result = [
    '00'=>'あいこ',
    '01'=>'あなたの勝ち',
    '02'=>'あなたの負け',
    '10'=>'あなたの負け',
    '11'=>'あいこ',
    '12'=>'あなたの勝ち',
    '20'=>'あなたの勝ち',
    '21'=>'あなたの負け',
    '22'=>'あいこ'
];
//連想配列は後でprintを使う場合、右側(値)を表示する文言に
print($result[$mine.$num]); ?>です。

<?php
if ($mine == $num) {
    print('あいこです');
} else if (($mine==0&&$num==1)||($mine==1&&$num==2)||($mine==2&&$num==20)) {
    print('あなたの勝ち');
} else {
    print('あなたの負け');
}
?>です。
<br>
<a href="index.html">再戦</a>
<hr>
</pre>
</main>
</body>    
</html>