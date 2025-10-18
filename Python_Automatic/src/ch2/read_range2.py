import openpyxl as xl

book = xl.load_workbook("test100.xlsx")
sheet = book.active

for row in sheet["b2:d4"]:
    r = []
    for cell in row:
        r.append(cell.value)
    print(r)