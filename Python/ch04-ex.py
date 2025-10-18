#p179 ex4-2
count = 1
okawari = 'y'
while okawari == 'y':#while Trueで無限ループにしてnの時にbreakで行ける
    print('カレーを召し上がれ')
    print(f'{count}皿のカレーを食べました')
    okawari = input('おかわりはいかがですか？(y/n)>>')
    count += 1
print('ごちそうさまでした')

#ex4-3
count = 10
for num in range(10):
    print(f'{count},',end='')
    count -= 1
print('Lift off!')

#ex4-4(1)
for i in range(1,10):
    for j in range(1,10):
        print(f'{i*j}|',end='')
    print('\n')

#ex4-4(2)
for i in range(1,10):
    if i % 2:
        for j in range(1,10):
            print(f'{i*j}|',end='')
        print('\n')
    else:
        continue
#ex4-4(3)
for i in range(1,10):
    if i % 2:
        for j in range(1,10):
            if i*j >= 50:
                continue
            print(f'{i*j}|',end='')
        print('\n')
    else:
        continue