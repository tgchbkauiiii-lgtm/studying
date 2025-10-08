<?php
session_start();
require_once 'dbconnect.php';

/* ---------- 認証チェック ---------- */
if (!isset($_SESSION['id']) || ($_SESSION['time'] + 3600) < time()) {
    header('Location: login.php');
    exit();
}
$_SESSION['time'] = time();

/* ---------- 投稿処理（フォームから送信された場合） ---------- */
if (isset($_POST['message']) && trim($_POST['message']) !== '') {
    $ins = $db->prepare('INSERT INTO posts SET member_id=?, message=?, created=NOW()');
    $ins->execute([
        $_SESSION['id'],
        $_POST['message']
    ]);
    header('Location: index.php');
    exit();
}

/* ---------- 流すコメントデータをDBから取得 ---------- */
$stmt = $db->query(
    'SELECT REPLACE(REPLACE(message, "\r\n", " "), "\n", " ") AS message FROM posts ORDER BY created DESC '
);
$commentsForJs = $stmt->fetchAll(PDO::FETCH_COLUMN, 0);

?>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ぞす系ちいかわ掲示板</title>
    <!-- 可愛らしいフォントを読み込む -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=M+PLUS+Rounded+1c:wght@500;700&display=swap" rel="stylesheet">
    <style>
        /* === ページ全体のスタイル === */
        body {
            font-family: 'M PLUS Rounded 1c', sans-serif;
            background-color: #fff0f5; /*ラベンダーブラッシュ*/
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            height: 100vh;
            margin: 0;
            color: #5d4037; /* 濃い茶色 */
        }

        h1 {
            font-weight: 700;
            font-size: 3rem;
            color: #ff8c94; /* コーラルピンク */
            text-shadow: 2px 2px 0 #ffffff, 4px 4px 0 #ffc4c8; /* 白と薄いピンクで立体的な影 */
            margin-bottom: 20px;
        }

        /* === コメントが流れるスクリーン === */
         #screen {
            width: 80vw;
            max-width: 960px;
            height: 70vh;
            background-color: #e0f7fa; /* 淡いシアン */
            border: 3px dashed #ffc4c8; /* ピンクの破線 */
            border-radius: 25px; /* 角を丸く */
            position: relative;
            overflow: hidden;
            box-shadow: 0 8px 20px rgba(0, 0, 0, 0.08); /* ふんわりした影 */
            transition: background-color 1.5s ease;
        }

        /* === 流れるコメントのスタイル === */
        .comment {
            position: absolute;
            left: 100%;
            white-space: nowrap;
            font-size: 2.8vmax;
            font-weight: 500;
            /* どんな背景色でも見えるように濃い文字色と白い影 */
            color: #4e342e; /* より濃い茶色 */
            text-shadow: 1px 1px 2px #fff, -1px -1px 2px #fff, 1px -1px 2px #fff, -1px 1px 2px #fff;
            animation-name: flow;
            animation-timing-function: linear;
            animation-iteration-count: 1;
        }

        /* === コメントを流すアニメーション === */
        @keyframes flow {
            from { transform: translateX(0); }
            to { transform: translateX(calc(-80vw - 100%)); }
        }

        /* === コメント入力フォーム === */
        #comment-form {
            margin-top: 20px;
            display: flex;
            width: 80vw;
            max-width: 960px;
        }

        #comment-input {
            flex-grow: 1;
            padding: 12px 20px;
            border: 2px solid #ffc4c8;
            border-radius: 30px; /* 角を丸く */
            font-size: 16px;
            font-family: 'M PLUS Rounded 1c', sans-serif;
            font-weight: 500;
            outline: none; /* クリック時の青い枠線を消す */
            transition: box-shadow 0.2s;
        }
        #comment-input:focus {
            box-shadow: 0 0 8px rgba(255, 140, 148, 0.5); /* フォーカス時にピンクの影 */
        }

        #submit-button {
            padding: 12px 25px;
            margin-left: 10px;
            border: none;
            background: linear-gradient(145deg, #ffc4c8, #ff8c94);
            color: white;
            border-radius: 30px;
            cursor: pointer;
            font-size: 16px;
            font-weight: 700;
            font-family: 'M PLUS Rounded 1c', sans-serif;
            box-shadow: 0 4px 10px rgba(255, 105, 180, 0.3);
            transition: transform 0.2s ease-out, box-shadow 0.2s ease-out;
        }
        #submit-button:hover {
            transform: scale(1.05); /* ぷくっと膨らむ */
            box-shadow: 0 6px 15px rgba(255, 105, 180, 0.4);
        }

        /* === ログアウトボタン === */
        .logout-link {
            position: absolute;
            top: 15px;
            right: 15px;
            color: #fff;
            background: rgba(255, 140, 148, 0.8);
            padding: 8px 12px;
            border-radius: 15px;
            text-decoration: none;
            font-size: 14px;
            transition: background-color 0.2s;
        }
        .logout-link:hover {
            background: rgba(255, 140, 148, 1);
        }

    </style>
</head>
<body>
  <h1>ぞす系ちいかわ</h1>
    
    <a href="index.php" class="logout-link">メインに戻る</a>

    <!-- コメントが流れるスクリーン部分 -->
    <div id="screen"></div>

    <!-- コメント入力フォーム (PHPと連携) -->
    <form id="comment-form" action="nikoniko.php" method="post">
        <input type="text" id="comment-input" name="message" placeholder="書けよそれが仕事だろ？戻れると思うなよ" autocomplete="off" required>
        <button type="submit" id="submit-button">投稿しちゃお</button>
    </form>


    <script>
    const commentsData = <?php echo json_encode($commentsForJs); ?>;

    document.addEventListener('DOMContentLoaded', () => {
        const screen = document.getElementById('screen');
        if (!screen) return;

        // --- コメントを流す処理 (変更なし) ---
        let commentIndex = 0;
        function flowComment(text) {
            const commentElement = document.createElement('div');
            commentElement.classList.add('comment');
            commentElement.textContent = text;

            const screenHeight = screen.clientHeight;
            const commentHeight = screen.clientHeight * 0.06;
            const maxTop = screenHeight - commentHeight;
            if (maxTop > 0) {
                commentElement.style.top = `${Math.floor(Math.random() * maxTop)}px`;
            } else {
                commentElement.style.top = '0px';
            }
            
            const duration = Math.random() * 7 + 8;
            commentElement.style.animationDuration = `${duration}s`;

            commentElement.addEventListener('animationend', () => {
                commentElement.remove();
            });

            screen.appendChild(commentElement);
        }
        
        function scheduleNextComment() {
            if (commentsData.length === 0) return;
            flowComment(commentsData[commentIndex]);
            commentIndex = (commentIndex + 1) % commentsData.length;
            const nextDelay = Math.random() * 1500 + 500;
            setTimeout(scheduleNextComment, nextDelay);
        }
        
        scheduleNextComment();

        /* ▼▼▼ 背景色をランダムなパステルカラーに変える処理 ▼▼▼ */

        // ランダムなパステルカラーを生成する関数
        function getRandomPastelColor() {
            const hue = Math.floor(Math.random() * 361);      // 色相 (0〜360)
            const saturation = Math.floor(Math.random() * 20) + 75; // 彩度 (75%〜95%)
            const lightness = Math.floor(Math.random() * 10) + 85;  // 輝度 (85%〜95%)
            return `hsl(${hue}, ${saturation}%, ${lightness}%)`;
        }

        // 3秒ごとに背景色をランダムなパステルカラーに変更
        setInterval(() => {
            screen.style.backgroundColor = getRandomPastelColor();
        }, 3000); // 3000ミリ秒 = 3秒
    });
    </script>
</body>
</html>