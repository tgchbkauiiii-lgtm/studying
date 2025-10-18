import openpyxl as xl

book = xl.Workbook()
sheet = book.active

sheet["a1"] = "2023/01/01"
sheet["b1"] = '=TEXT(A1,"ggge年m月d日")'

book.save("susiki.xlsx")