#code3-2
name = input('あなたの名前を教えてください>>')
print(f'{name}さん、こんにちは')
food = input(f'{name}さんの好きな食べ物を教えてください>>')
if food == 'カレー':
    print('素敵です。カレーは最高ですよね!!')
else:
    print(f'私も{food}が好きですよ')

#code3-3
score = int(input('試験の点数を入力してください>>'))
if score >= 60:
    print('合格！')
    print('よく頑張りましたね')
else:
    print('残念ながら不合格です')
    print('追試を受けてください')

#code3-4
name = input('あなたの名前を教えてください>>')
print(f'{name}さん、こんにちは')
food = input(f'{name}さんの好きな食べ物を教えてください>>')
if 'カレー' in food:
    print('素敵です。カレーは最高ですよね!!')
else:
    print(f'私も{food}が好きですよ')
    
#code3-5
scores = [80,100,20,60]
if 100 in scores:
    print('100点満点の試験があったんですね。おめでとう‼')
else:
    print('次はどれか一つでも100点満点をとろう')

#code3-6
scores = {'network':60,'database':80,'security':50}
key = input('追加する科目名を入力してください>>')
if key in scores:
    print('既に登録済みです')
else:
    data = int(input('得点を入力してください>>'))
    scores[key] = data
print(scores)

#code3-10
print('すべての質問にyまたはnで答えてください')
okane_aruka = input('お金に余裕はありますか？>>')
if okane_aruka == 'y':
    onaka_suiteruka = input('おなかが凄く空いていますか？>>')
    nomitai_kibunnka = input('ビールを飲みたいですか？>>')
    if onaka_suiteruka == 'y' and nomitai_kibunnka == 'y':
        print('焼肉はいかがですか？')
    elif onaka_suiteruka == 'y':
        print('カレーはいかがですか？')
    elif nomitai_kibunnka == 'y':
        print('焼き鳥はいかがですか？')
    else:
        print('パスタはいかがですか？')
    yashoku_iruka = input('夜食は必要ですか？>>')
    if yashoku_iruka == 'y':
        print('コンビニのチキンはいかがですか')
else:
    print('家で食べましょう')

#p151 ex3-3(1)
isError = input('エラー判定用変数です。入力してください>>')
n = int(input('100までの整数値を入力してください>>'))
if (not (isError) and n < 100):
    print('条件を満たしています')

#ex3-3(2)
num = int(input('任意の整数を入力してください'))
if num % 2 == 0:
    print(f'入力された値{num}は偶数です')
else:
    print(f'入力された値{num}は奇数です')

#ex3-3(3)
greet = input('あいさつbotです。一言どうぞ>>')
if greet == 'こんにちは':
    print('ようこそ！')
elif greet == '景気は？':
    print('ぼちぼちです')
elif greet == 'さようなら':
    print('お元気で！')
else:
    print('どうしました？')