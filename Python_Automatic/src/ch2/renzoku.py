import openpyxl as ex
book = ex.Workbook()
sheet = book.active
for i in range(10):
    sheet.cell(row=(i+1),column=1,value=i)
book.save("renzoku.xlsx")