dummy_data = [
    ["伊藤",300],
    ["伊藤",600],
    ["伊藤",200],
    ["田中",300],
    ["田中",200]
]

users = {}
for row in dummy_data:
    name, value = row
    if name not in users:
        users[name] = []
    users[name].append(row)

for name, rows in users.items():
    print(rows)
    total = 0
    for row in rows:
        total += row[1]
        print(name,total)