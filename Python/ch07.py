#code7-1
text = input('何を記録しますか？>>')
file = open('diary.txt','a')
file.write(text + '\n')
file.close()
#pythonで作ったファイルはShift-JIS形式で書かれるので、UTF-8のVScode上では文字化けする
#メモ帳とかでこのファイルを開けば普通に見える

#code7-3
import math as m
print(f'円周率は{m.pi}です')
print(f'小数点以下を切り捨てれば{m.floor(m.pi)}です')
print(f'小数点以下を切り上げれば{m.ceil(m.pi)}です')

#code7-4
#%matplotlib inline 今回の環境ではいらない
import matplotlib.pyplot as plt

weight = [68.4,68.0,69.5,68.4,68.6,70.2,71.4,70.8,68.5,68.6,68.3,68.4]
plt.plot(weight)
plt.show()

#code7-13
import requests

response = requests.get('https://www.python.org/downloads/')
text = response.text
print(text)


# %%
#p295 ex7-6
from random import randint as rand
print('数当てゲームを始めます。3桁の数を当ててください！')
answer = [rand(0,10),rand(0,10),rand(0,10)]
while True:
    prediction = [
        int(input('1桁目の予想を入力(0~9)>>')),
        int(input('2桁目の予想を入力(0~9)>>')),
        int(input('3桁目の予想を入力(0~9)>>'))
    ]
    hit = 0
    ball = 0
    for i in range(3):
        if answer[i] == prediction[i]:
            hit += 1
        else:
            for j in range(3):
                if answer[j] == prediction[i]:
                    ball += 1
    print(f'hit:{hit} ball:{ball}')