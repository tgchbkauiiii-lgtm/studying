# %%
import openpyxl as excel
book = excel.Workbook()
sheet = book.active
sheet["A1"] = "こんにちは"
book.save("hello.xlsx")
# %%
