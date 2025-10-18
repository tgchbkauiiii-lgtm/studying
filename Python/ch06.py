#code6-3
userinfo = input('名前と血液型をカンマで区切って1行で入力>>')
[name,blood] = userinfo.split(',')
blood = blood.upper().strip()
print(f'{name}さんは{blood}型なので大吉です')

#code6-5
class Hero:
    name = '松田'
    hp = 100
    def sleep(self,hours):
        print(f'{self.name}は{hours}時間寝た！')
        self.hp += hours

#ゲーム開始

print('スッキリファンタジーⅫ～金色の理想郷～')
h = Hero()
h.sleep(3)
print(f'{h.name}のHPは現在{h.hp}です')

#code6-6
scores1 = [80,40,50]
scores2 = [80,40,50]
print(f'{scores1}のidentity:{id(scores1)}')
print(f'{scores2}のidentity:{id(scores2)}')
if scores1 == scores2:
    print('scores1とscores2は同じ内容です')
else:
    print('scores1とscores2は違う内容です')

if id(scores1) == id(scores2):
    print('scores1とscores2は同じ存在です')
else:
    print('scores1とscores2は違う存在です')

#code6-7
scores1 = [80,40,50]
scores2 = [80,40,50]
print(f'{scores1}の先頭要素は{scores1[0]}')
print(f'{scores2}の先頭要素は{scores2[0]}')

print('変数scores2の中身を変数scores1に代入（コピー）します')
scores1 = scores2 
#コンテナの中身を代入するわけじゃなく、identity値を同じにしちゃってる

print('scores1の先頭要素を90に書き換えます')
scores1[0] = 90

print(f'90を代入したscores1の先頭要素は{scores1[0]}')
print(f'90を代入していないscores2の先頭要素は{scores2[0]}')
#代入の後はscores1と2でidentity値が同じになってる、参照するところが同じ

#code6-8
def add_suffix(names):
    for i in range(len(names)):
        names[i] = names[i] + 'さん'
    return names

before_names = ['松田','浅木','工藤']
after_names = add_suffix(before_names)
print('さん付け後:' + after_names[0])
print('さん付け前:' + before_names[0])

#code6-9
def add_suffix(names):
    for i in range(len(names)):
        names[i] = names[i] + 'さん'
    return names

before_names = ['松田','浅木','工藤']
copied_names = list()
for n in before_names:
    copied_names.append(n)
after_names = add_suffix(copied_names)
print('さん付け後:' + after_names[0])
print('さん付け前:' + before_names[0])