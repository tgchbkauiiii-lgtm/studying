import openpyxl as xl

book = xl.load_workbook("test100.xlsx")
sheet = book.active

for row in sheet["b2:d4"]:
    print([c.value for c in row])