import openpyxl as ex
book = ex.Workbook()
sheet = book.active
for i in range(1,10):
    for j in range(1,10):
        cell = sheet.cell(row=i,column=j)
        cell.value = i * j
book.save("kuku.xlsx")