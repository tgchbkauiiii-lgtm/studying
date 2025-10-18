import win32com.client as com
import os
scr_file = os.path.abspath(__file__)
scr_dir = os.path.dirname(scr_file)
in_file = f'{scr_dir}/date-sample.xlsx'
pdf_file = f'{scr_dir}/date-sample.pdf'

app = com.Dispatch("Excel.Application")
app.Visible = True
app.DisplayAlerts = False

book = app.Workbooks.Open(in_file)

xlTypePDF = 0
book.ExportAsFixedFormat(xlTypePDF,pdf_file)

app.Quit()