import openpyxl as xl

book = xl.load_workbook("test100.xlsx")
sheet = book.active

it = sheet.iter_rows(
    min_row=2,min_col=2,
    max_row=4,max_col=4
)

for row in it:
    print([c.value for c in row])