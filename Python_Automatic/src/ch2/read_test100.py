import openpyxl as xl

book = xl.load_workbook("test100.xlsx")
sheet = book.active
print(sheet["H2"].value)
cell = sheet.cell(row=2,column=8)
print(cell.value)