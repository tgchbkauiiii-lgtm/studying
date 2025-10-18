#p225 ex5-2
def is_leapyear(year):
    judge = ''
    if year % 400 == 0:
        print(f'西暦{year}年はうるう年です')
    elif year%4==0 and year%100==0:
        print(f'西暦{year}年はうるう年ではありません')
    elif year % 4 == 0:
        print(f'西暦{year}年はうるう年です')
    else:
        print(f'西暦{year}年はうるう年ではありません')

year = int(input('西暦年数を入力してください>>'))
is_leapyear(year)

#ex5-3
def take_bus():
    print('バスに乗ります')
def walk():
    print('ちょっと歩きます')
def run():
    print('走ります！')
    walk()

print('行ってきます!')
walk(); take_bus(); run(); run()
print('ただいま')
