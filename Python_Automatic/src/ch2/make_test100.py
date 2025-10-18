import openpyxl as ex
book = ex.Workbook()
sheet = book.active
for i in range(1,101):
    for j in range(1,101):
        cell = sheet.cell(row=i,column=j)
        cell.value = cell.coordinate
book.save("test100.xlsx")