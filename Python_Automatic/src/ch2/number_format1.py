import openpyxl as xl
import math

book = xl.Workbook()
sheet = book.active

val = math.pi
sheet.append([val,val,val])

sheet["a1"].number_format = "0.000000000000"
sheet["b1"].number_format = "0.00"
sheet["c1"].number_format = "0.0000"

book.save("number_format1.xlsx")