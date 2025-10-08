// slideをslickで実装
$(function () {
    $('.slide-wrap').slick({
        accessibility: true,
        autoplay: true,
        autoplaySpeed: 3000,
        adaptiveHeight: true, 
        speed: 400,
        // レスポンシブ設定を追加
        responsive: [
            {
                breakpoint: 768, // 767px以下の場合
                settings: {
                    adaptiveHeight: true, // 
                    slidesToShow: 1, // 1枚ずつ表示
                    slidesToScroll: 1
                }
            }
        ]
    });


    // // スライド内の画像リンクをクリックしたときの処理
    // // .slide-wrap内の .open-explanation-toggle クラスを持つaタグにイベントリスナーを設定
    // $('.slide-wrap').on('click', 'div.item', function(e) {
    //     e.preventDefault(); // デフォルトのリンク動作をキャンセル

    //     var $clickedItem = $(this).closest('div'); // クリックされたaタグを含むスライダーのdiv要素
    //     var $explanation = $clickedItem.find('.item-explanation'); // そのdiv内の解説要素

    //     // 他の開いている解説を閉じる
    //     // クリックされたアイテムではない、かつ表示されている全ての.item-explanationをスライドアップ
    //     $('.item-explanation').not($explanation).slideUp(function() {
    //         // スライドアップ完了後にSlickの位置を再設定
    //         $('.slide-wrap').slick('setPosition');
    //     });

    //     // クリックされたアイテムの解説をトグル表示
    //     $explanation.slideToggle(function() {
    //         // スライドトグル完了後にSlickの位置を再設定
    //         $('.slide-wrap').slick('setPosition');
    //     });
    // });

    // // スライダーが変更されたときに、開いている解説を閉じる
    // $('.slide-wrap').on('beforeChange', function(event, slick, currentSlide, nextSlide){
    //     $('.item-explanation').slideUp(function() {
    //         // スライドアップ完了後にSlickの位置を再設定
    //         $('.slide-wrap').slick('setPosition');
    //     });
    // });
});

// function caption() {
//     explanations[i].style.display = 'block';
// }

const items = document.querySelectorAll('.item');
console.log(items);
const explanations = document.querySelectorAll('.item-explanation');
console.log(explanations);

// items.addEventListener('click', caption);

// for (let item of items) {
//     let i = 0;
//     items[i].addEventListener('click', caption);
// }

items.forEach((item, index) => {
    item.addEventListener('click', () => {
        const clickedExplanation = explanations[index];
        // クリックされた解説が現在表示されているか確認
        const isActive = clickedExplanation && clickedExplanation.style.display === 'block';

        // まず、すべての解説を非表示にする（クリックされたもの以外）
        explanations.forEach(exp => {
            if (exp !== clickedExplanation) {
                exp.style.display = 'none';
            }
        });

        // クリックされたアイテムに対応する解説の表示/非表示を切り替える
        if (clickedExplanation) {
            clickedExplanation.style.display = isActive ? 'none' : 'block';
        }

        // Slickスライダーのレイアウトを更新して、要素の重なりを防ぐ
        const slideWrap = item.closest('.slide-wrap');
        if (slideWrap && $(slideWrap).hasClass('slick-initialized')) {
            // DOMの更新がブラウザに反映されるのを少し待ってからsetPositionを実行
            setTimeout(() => {
                $(slideWrap).slick('setPosition');
            }, 0); // 0msの遅延でも、次の描画サイクルで実行されることが期待できます
        }
    });
});

