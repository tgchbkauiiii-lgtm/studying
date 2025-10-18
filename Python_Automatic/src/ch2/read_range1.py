import openpyxl as xl

book = xl.load_workbook("test100.xlsx")
sheet = book.active
for y in range(2,5):
    r = []
    for x in range(2,5):
        v = sheet.cell(row=y,column=x).value
        r.append(v)
    print(r)