#  %%
import random as rnd #インポート
print('数当てゲームを始めます。３桁の数を当ててください！')
answer = list()#答え格納用空のリスト
for i in range(3):#当たりをランダムで取得
    answer.append(rnd.randint(0,9))
#print(answer)#確認用

game_counter = 0#何回目の繰り返しか数えます。

while True:#無限ループ
    game_counter+=1#繰り返し回数加算
    print(f'-+-+-{game_counter}回目の予想-+-+-')
    prediction = list()#入力受付用リスト
    hit=0#当たりの数
    ball=0#あるけどはずれのやつ
    for i in range(3):#３回入力受付しながら判定
        prediction.append(int(input(f'{i+1}桁目の予想を入力->')))
        if answer[i] == prediction[i]:#あったらhit加算
            hit+=1
        else:#なかったら他にないか探す
            for j in range(3):#他の場所にあったらball加算
                if answer[j]==prediction[i]:
                    ball+=1

    print(f'Hit:{hit} Ball:{ball}')#結果表示
    if hit==3:#正解なら
        print('正解です！')
        break
    else:#不正解なら
        continue_game = int(input('続けますか？1:続ける2:終了 >> '))
        if continue_game == 2:#終了処理
            print(f'正解は:{answer}')
            break
# %%
