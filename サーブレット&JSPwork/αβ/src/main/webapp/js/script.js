// script.js

document.addEventListener('DOMContentLoaded', () => {
    const slides = document.querySelectorAll('.carousel-slide');
    const dots = document.querySelectorAll('.dot');
    let currentSlide = 0;
    const slideInterval = 8000; // 8秒ごとに切り替え
    let intervalId;

    /**
     * 指定したインデックスのスライドを表示する
     * @param {number} index - 表示したいスライドのインデックス
     */
    function showSlide(index) {
        // 全てのスライドとドットからアクティブクラスを削除
        slides.forEach(slide => {
            slide.classList.remove('active-slide');
            // 非アクティブになった動画は再生を一時停止
            slide.querySelector('.hero-video').pause();
        });
        dots.forEach(dot => dot.classList.remove('active-dot'));

        // インデックスを循環させる (0 -> 1 -> 0...)
        currentSlide = (index + slides.length) % slides.length;

        // 新しいスライドとドットにアクティブクラスを追加
        slides[currentSlide].classList.add('active-slide');
        dots[currentSlide].classList.add('active-dot');

        // アクティブになった動画を再生
        // ※このplay()にはユーザーのジェスチャーが必要な場合があるため、自動再生されない可能性あり
        slides[currentSlide].querySelector('.hero-video').play().catch(e => console.log('Video play failed:', e));
    }

    /**
     * 次のスライドに進む
     */
    function nextSlide() {
        showSlide(currentSlide + 1);
    }

    // 1. 自動切り替えの開始
    // 初回ロード時は最初の動画がCSSによって表示されているため、nextSlideから始める
    intervalId = setInterval(nextSlide, slideInterval);

    // 2. ドット（インジケーター）のクリック制御
    dots.forEach(dot => {
        dot.addEventListener('click', function() {
            // 現在の自動切り替えをクリア
            clearInterval(intervalId); 

            // クリックされたドットのデータ属性からインデックスを取得
            const index = parseInt(this.getAttribute('data-slide-index'));
            showSlide(index);

            // 切り替え後、再度自動切り替えを再開
            intervalId = setInterval(nextSlide, slideInterval);
        });
    });

    // 初回は最初のスライドを明示的に開始
    showSlide(0); 
});

//ハンバーガー用
document.addEventListener('DOMContentLoaded', () => {
  const hamburger = document.querySelector('.hamburger-grid');
  const nav = document.querySelector('.nav-grid');
  const links = document.querySelectorAll('.nav-grid__link');

  hamburger.addEventListener('click', () => {
    hamburger.classList.toggle('active');
    nav.classList.toggle('active');

    const isOpen = hamburger.classList.contains('active');
    hamburger.setAttribute('aria-expanded', isOpen);
    nav.setAttribute('aria-hidden', !isOpen);
    document.body.style.overflow = isOpen ? 'hidden' : '';

    // リンクのアニメーションディレイを設定
    if (isOpen) {
      links.forEach((link, index) => {
        link.style.transitionDelay = `${0.2 + (index * 0.1)}s`;
      });
    } else {
      links.forEach(link => {
        link.style.transitionDelay = '0s';
      });
    }
  });

      // ▼▼▼ ここから追加 ▼▼▼
    links.forEach(link => {
        link.addEventListener('click', () => {
            // リンクをクリックしたら、メニューを閉じる処理を実行
            if (nav.classList.contains('active')) {
                // ハンバーガーボタンのクリックイベントをシミュレートして閉じる
                hamburger.click(); 
            }
        });
    });
    // ▲▲▲ ここまで追加 ▲▲▲

  // アクセシビリティのためのキーボードナビゲーション
  nav.addEventListener('keydown', (e) => {
    if (e.key === 'Escape' && nav.classList.contains('active')) {
      hamburger.click();
    }
  });
});


// ▼▼▼ RECOMMENDカルーセル用のJSを追加 ▼▼▼
document.addEventListener('DOMContentLoaded', () => {
    const carousel = document.querySelector('.recommend-carousel');
    const prevButton = document.querySelector('.carousel-arrow.prev');
    const nextButton = document.querySelector('.carousel-arrow.next');
    
    // 要素が存在しない場合は処理を中断
    if (!carousel || !prevButton || !nextButton) return;

    let currentIndex = 0;

    function updateCarousel() {
        // 1アイテムあたりのスクロール量を計算
        const item = carousel.querySelector('.product-item');
        const gap = parseInt(window.getComputedStyle(carousel).gap);
        const scrollAmount = item.offsetWidth + gap;
        
        // カルーセルを移動
        carousel.style.transform = `translateX(-${currentIndex * scrollAmount}px)`;
    }

    nextButton.addEventListener('click', () => {
        const items = carousel.querySelectorAll('.product-item');
        // 表示されているアイテム数を画面幅から計算
        const itemsInView = Math.floor(carousel.parentElement.offsetWidth / (items[0].offsetWidth + parseInt(window.getComputedStyle(carousel).gap)));
        
        if (currentIndex < items.length - itemsInView) {
            currentIndex++;
            updateCarousel();
        }
    });

    prevButton.addEventListener('click', () => {
        if (currentIndex > 0) {
            currentIndex--;
            updateCarousel();
        }
    });

    // ウィンドウサイズが変更された時にも位置を再計算
    window.addEventListener('resize', updateCarousel);
});