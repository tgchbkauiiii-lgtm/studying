// --- メディアファイルのリスト ---
const gifs = [
  'zosu_gif/export_01.gif',
  'zosu_gif/export_02.gif',
  'zosu_gif/export_03.gif',
  'zosu_gif/export_04.gif',
  'zosu_gif/export_05.gif',
  'zosu_gif/export_06.gif',
  'zosu_gif/export_07.gif',
  'zosu_gif/zosu_4535.gif',
  'zosu_gif/zosu_4543.gif'
];

const videos = [
  'zosu_mp4/zosu_20250701_184030_1.mp4',
  'zosu_mp4/zosu_20250701_184224_1a.mp4',
  'zosu_mp4/zosu_20250701_184224_1b.mp4',
  'zosu_mp4/zosu_20250701_184224_1.mp4',
  'zosu_mp4/zosu_20250701_184458_1a.mp4',
  'zosu_mp4/zosu_20250701_184458_1b.mp4',
  'zosu_mp4/zosu_20250701_184458_1c.mp4',
  'zosu_mp4/zosu_20250701_184458_1.mp4',
  'zosu_mp4/zosu_20250701_184458_ezgif1.mp4',
  'zosu_mp4/zosu_20250701_184458_ezgif2.mp4',
  'zosu_mp4/zosu_20250701_184622_1.mp4',
  'zosu_mp4/zosu_20250701_184622_1a.mp4',
  'zosu_mp4/zosu_20250701_184622_1b.mp4',
  'zosu_mp4/zosu_20250701_184622_1z.mp4',
  'zosu_mp4/zosu_20250701_185040_1.mp4'
];

let showGifNext = true;
let gifIndex = 0;
let videoIndex = 0;
let popupTimer = null;
let currentMedia = null;

function setButtonListeners(parent) {
  parent.querySelectorAll('.like').forEach(btn => {
    btn.addEventListener('click', () => {
      btn.classList.toggle('active');
    });
  });

  parent.querySelectorAll('.dislike').forEach(btn => {
    btn.addEventListener('click', () => {
      btn.classList.toggle('active');
    });
  });

  parent.querySelectorAll('.zosu').forEach(btn => {
    btn.addEventListener('click', () => {
      btn.disabled = true;

      const popup = document.getElementById('popup');
      const gif = document.getElementById('popupGif');
      const video = document.getElementById('popupVideo');

      if (popupTimer) clearTimeout(popupTimer);
      if (currentMedia === 'video') {
        video.pause(); video.loop = false; video.src = '';
      } else if (currentMedia === 'gif') {
        gif.src = '';
      }

      if (showGifNext) {
        const currentGif = gifs[gifIndex];
        gifIndex = (gifIndex + 1) % gifs.length;
        showGifNext = false;

        gif.src = currentGif;
        gif.style.display = 'block';
        video.style.display = 'none';
        popup.style.display = 'block';
        currentMedia = 'gif';

        popupTimer = setTimeout(() => {
          popup.style.display = 'none';
          gif.src = '';
          currentMedia = null;
          btn.disabled = false;
        }, 8000);
      } else {
        const currentVideo = videos[videoIndex];
        videoIndex = (videoIndex + 1) % videos.length;
        showGifNext = true;

        video.src = currentVideo;
        video.loop = true;
        gif.style.display = 'none';
        video.style.display = 'block';
        popup.style.display = 'block';
        currentMedia = 'video';
        video.play();

        popupTimer = setTimeout(() => {
          popup.style.display = 'none';
          video.pause(); video.src = ''; video.loop = false;
          currentMedia = null;
          btn.disabled = false;
        }, 8000);
      }
    });
  });
}

// 初期のボタンにも適用
setButtonListeners(document);

// 投稿フォーム
const postForm = document.getElementById('postForm');
const postInput = document.getElementById('postInput');
const charCount = document.getElementById('charCount');
const postArea = document.querySelector('.post');

postInput.addEventListener('input', () => {
  charCount.textContent = `${postInput.value.length} / 140`;
});

postForm.addEventListener('submit', (e) => {
  e.preventDefault();
  const text = postInput.value.trim();
  if (text === '' || text.length > 140) return;

  const newPost = document.createElement('div');
  newPost.classList.add('post');
  newPost.innerHTML = `
    <p class="text">${escapeHtml(text)}</p>
    <div style="text-align: right; font-size: 12px; color: #666;">${getNow()}</div>
    <div class="buttons">
      <button class="like">❤️</button>
      <button class="dislike">💔</button>
      <button class="zosu">☢️</button>
    </div>
  `;

  document.body.insertBefore(newPost, postArea);
  setButtonListeners(newPost);

  postInput.value = '';
  charCount.textContent = '0 / 140';
});

// 時刻表示
function getNow() {
  const d = new Date();
  return `${d.getFullYear()}/${pad(d.getMonth() + 1)}/${pad(d.getDate())} ${pad(d.getHours())}:${pad(d.getMinutes())}:${pad(d.getSeconds())}`;
}
function pad(n) {
  return n.toString().padStart(2, '0');
}

// XSS対策
function escapeHtml(str) {
  return str.replace(/&/g, "&amp;")
            .replace(/</g, "&lt;")
            .replace(/>/g, "&gt;");
}
