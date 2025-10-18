#code5-4
def hello():
    print('こんにちは。工藤です。')

hello()

#定義の前に呼び出しは禁止

#code5-6
def hello(name):
    print(f'こんにちは。{name}です。')

hello('浅木')
hello('松田')

#code5-7
def profile(name,age,hobby):
    print(f'私の名前は{name}です。')
    print(f'年齢は{age}歳です。')
    print(f'趣味は{hobby}です。')

profile('浅木','24','カフェ巡り')

#code5-11
def plus(x,y):
    answer = x + y
    return answer

answer = plus(100,50)
print(f'足し算の答えは{answer}です。')

#code5-12
def input_scores(name):
    print(f'{name}さんの試験結果を入力してください')
    network = int(input('ネットワークの得点？>>'))
    database = int(input('データベースの得点？>>'))
    security = int(input('セキュリティの得点？>>'))
    scores = [network,database,security]
    return scores

def calc_average(scores):
    avg = sum(scores) / len(scores)
    return avg

def output_result(name,avg):
    print(f'{name}さんの平均点は{avg}です。')

#浅木と松田の得点入力
asagi_scores = input_scores('浅木')
matsuda_scores = input_scores('松田')
#平均点の計算
asagi_avg = calc_average(asagi_scores)
matsuda_avg = calc_average(matsuda_scores)
#結果を出力
output_result('浅木',asagi_avg)
output_result('松田',matsuda_avg)

#code5-16
def eat(breakfast,lunch,dinner='カレー'):
    print(f'朝は{breakfast}を食べました')
    print(f'昼は{lunch}を食べました')
    print(f'晩は{dinner}を食べました')

print('8月1日')
eat('トースト','おにぎり')
print('8月2日')
eat('納豆ご飯','ラーメン')
print('8月3日')
eat('バナナ','そば','焼肉')
print('8月4日')
eat('サンドウィッチ','シュウマイ弁当')

#code5-20
def eat(breakfast,lunch,dinner='カレー',*desserts):
    print(f'朝は{breakfast}を食べました')
    print(f'昼は{lunch}を食べました')
    print(f'晩は{dinner}を食べました')
    for d in desserts:
        print(f'おやつに{d}を食べました')

eat('トースト','パスタ','カレー','アイス','チョコ','カレー')