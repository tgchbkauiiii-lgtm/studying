# %%
import openpyxl as xl

wareki_table = [
    {"name":"弘化","start":1845,"end":1848},
    {"name":"嘉永","start":1848,"end":1855},
    {"name":"安政","start":1855,"end":1860},
    {"name":"万延","start":1860,"end":1861},
    {"name":"文久","start":1861,"end":1864},
    {"name":"元治","start":1864,"end":1865},
    {"name":"慶応","start":1865,"end":1868},
    {"name":"明治","start":1868,"end":1912},
    {"name":"大正","start":1912,"end":1926},
    {"name":"昭和","start":1926,"end":1989},
    {"name":"平成","start":1989,"end":2019},
    {"name":"令和","start":2019,"end":9999}
]

def seireki_wareki(year):
    for w in wareki_table:
        if w["start"] <= year < w["end"]:
            y = str(year - w["start"] + 1) + "年"
            if y == "1年":y = "元年"
            return w["name"] + y
    return "不明"

book = xl.Workbook()
sheet = book.active

sheet["a1"] = "西暦"
sheet["b1"] = "和暦"

start_y = 1845
for i in range(200):
    sei = start_y + i
    wa = seireki_wareki(sei)
    sheet.cell(row=(2+i),column=1,value=str(sei)+"年")
    sheet.cell(row=(2+i),column=2,value=wa)
    print(sei,"=",wa)

book.save("wareki.xlsx")

# %%
