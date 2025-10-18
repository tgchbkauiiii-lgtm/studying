import openpyxl as xl

book = xl.load_workbook(
    "uriage.xlsx",
    data_only=True)
sheet = book.active

rows = sheet["a3:f999"]
for row in rows:
    values = [cell.value for cell in row]
    if values[0] is None: break
    print(values)