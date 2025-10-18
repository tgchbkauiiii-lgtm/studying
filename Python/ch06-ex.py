def welcome(u):
    print(f'ようこそ{u["name"]}さん')
    u['age'] = u['age'] + 1
    print(f'あなたは来年{u["age"]}歳だから大吉です！')

username = input('名前を入力してください>>')
userage = int(input('年齢を入力してください>>'))
user = {'name':username,'age':userage}
user_copy = user.copy()
welcome(user_copy)
print(f'{user["age"]}歳の{user["name"]}さん、またプレイしてくださいね')