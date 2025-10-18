#1-4
print('Python'+'の世界へようこそ')
print('Pythonは'+'とっても'*3 + '楽しいですよ')

#1-10
name = '松田'
age = 22
print(name)
print(age)

import keyword
print(keyword.kwlist)

#1-16
age=24
age+=1
print(age)
price=2600
price*=1.5
print(price)

#1-17
"""
name = input('あなたのお名前を入力してください-->')
print('おお'+ name +'よ、そなたが来るのを待っておったぞ！')
"""

#1-20
x=10
print(type(x))

#1-22
x=3.14
y=int(x)
print(y)
print(type(y))
z=str(x)
print(z)
print(type(z))
print(z*2)

#1-25
name='松田光太'
age=23
height=175.6
print('私の名前は{}で、年齢は{}歳で、身長は{}cmです'.format(name,age,height))

#p78 ex1-3
height = float(input('身長をcmで入力してください'))/100
weight = float(input('体重をkgで入力してください'))
BMI = weight/height/height
print(f'あなたのBMI指数は{BMI}です')