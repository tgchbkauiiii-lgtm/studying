import openpyxl as xl

book = xl.load_workbook(
    "uriage.xlsx",
    data_only=True)
sheet = book.active

rows = sheet["a3:f9"]
for row in rows:
    values = [cell.value for cell in row]
    print(values)