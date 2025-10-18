#code4-2
count = 0
while count < 3:
    count += 1
    print(f'羊が{count}匹')
print('おやすみなさい')

#code4-4
is_awake = True
count = 0
while is_awake == True:
    count += 1
    print(f'ひつじが{count}匹')
    key = input('もう眠りそうですか？(y/n)>>')
    if key == 'y':
        is_awake = False
print('おやすみなさい')

#code4-7
scores = [80,20,75,60]
for data in scores:
    if data >= 60:
        print('合格')
    else:
        print('不合格')

#code4-8
for num in range(3):
    print('Pythonは楽しい')


#code4-10
ages = [28,50,8,20,78,25,22,10,27,33]
num = 5
samples = list()
for data in ages:
    if 20 <= data < 30:
        samples.append(data)
        if len(samples) == num:
            break
print(samples)

#code4-11
ages = [28,50,'ひみつ',20,78,25,22,10,'無回答',33]
samples = list()
for data in ages:
    if not isinstance(data,int):
        continue
    if data < 20 or data >= 30:
        continue
    samples.append(data)
print(samples)

#p179 ex4-2
count = 1
okawari = 'y'
while okawari == 'y':
    print('カレーを召し上がれ')
    print(f'{count}皿のカレーを食べました')
    okawari = input('おかわりはいかがですか？(y/n)>>')
    count += 1
print('ごちそうさまでした')

#ex4-3
count = 10
for count in range(9):
    print(f'{count},',end='')
    count -= 1
print('Lift off!')