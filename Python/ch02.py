#code2-2
members = ['工藤','松田','浅木']
print(members)
print(members[0])
print(members[1])
print(members[2])

#加藤さん豆知識：割り算の結果は必ずfloatになる

#code2-6
scores = [88,90,95]
total = sum(scores)
print(f'合計{total}点')
ave = total / len(scores)
print(f'合計{int(total)}点、平均{int(ave)}点')

#code2-8,9,10
members.append('菅原')
members.append('湊')
members.append('朝香')
print(members)

members.remove('松田') #members.remove[1]みたいなことはできないっぽい
print(members) 

members[0] = '田口'
print(members)

#code2-11,12
a = [10,20,30,40,50]
print(a[1:3]) #3未満
print(a[2:])
print(a[:3]) #list[a:b]と書くとb"未満"になることに注意

print(a[-1]) #ケツから1個目
print(a[-2]) #ケツから2個目

#code2-13
scores = {'network':60,'database':80,'security':50}
print(scores)

#code2-15
scores['programming'] = 65
scores['security'] = 55
print(scores)

#code2-17
scores = (70,80,55)
print(scores)
print(scores[0])
print(f'要素数は{len(scores)}')
print(f'合計は{sum(scores)}')

#code2-22
scores = {70,80,55,80}
scores.add(80)
print(scores)
print(f'要素数は{len(scores)}')
print(f'合計は{sum(scores)}')

#code2-23
scores = {'network':60,'database':80,'security':60}
mambers = ['松田','浅木','工藤']
print(tuple(members))
print(list(scores))
print(set(scores.values()))

#code2-24
matsuda_scores = {'network':60,'database':80,'security':50}
asagi_scores = {'network':80,'database':75,'security':92}
member_scores = {
    '松田':matsuda_scores,
    '浅木':asagi_scores
}
print(member_scores)
print(member_scores['松田'])

#code2-25
member_hobbies = {
    '松田':{'SNS','麻雀','自転車'},
    '浅木':{'麻雀','食べ歩き','数学','数学','数学'}
}
print(member_hobbies)
print(member_hobbies['松田'])
print(member_hobbies['浅木'])

#code2-26
a = [1,2,3]
b = [4,5,6]
c = [a,b]
print(c)
print(c[0])
print(c[1][2])

#code2-27
common_hobbies = member_hobbies['松田'] & member_hobbies['浅木']
print(common_hobbies)

#code2-28
A = {1,2,3,4}
B = {2,3,4,5}
print(A | B)
print(A & B)
print(A - B)
print(A ^ B)

#p117 ex2-2
print('各教科の点数を入力してください')
test_result = {
    '国語':int(input('国語の点数-->')),
    '算数':int(input('算数の点数-->')),
    '理科':int(input('理科の点数-->')),
    '社会':int(input('社会の点数-->')),
    '英語':int(input('英語の点数-->')),
}
print(f'合計点は{sum(test_result.values())}点、平均点は{sum(test_result.values())/len(test_result)}点です')

#ex2-3
hobbies = [
    {'麻雀','ギター','ミリタリー','ファッション','物理'},
    {'ドラム','ゲーム','筋トレ','麻雀','サウナ'}
]
input('心の準備ができたらEnterキーを押してください')
match = len(hobbies[0] & hobbies[1]) / len(hobbies[0] | hobbies[1]) * 100
print(f'あなたとお相手の相性度は{match}％です')