import openpyxl as xl

book = xl.Workbook()
sheet = book.active

def set_cell(cname,value,fmt):
    c = sheet[cname]
    c.value = value
    c.number_format = fmt

keta3_fmt = '#,##0'
sheet["a1"] = keta3_fmt
set_cell("b1",12345,keta3_fmt)
set_cell("c1",123456789,keta3_fmt)

cur_fmt = '"¥"#,##0;"¥"\\-#,##0'
sheet["a2"] = cur_fmt
set_cell("b2",12345,cur_fmt)
set_cell("c2",-12345,cur_fmt)

num_fmt = '#,##0;[red]"△"#,##0'
sheet["a3"] = num_fmt
set_cell("b3",12345,num_fmt)
set_cell("c3",-12345,num_fmt)

book.save("number_format2.xlsx")