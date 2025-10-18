import msoffcrypto
import openpyxl as xl

fin = open("uriage-encrypt.xlsx","rb")
msfile = msoffcrypto.OfficeFile(fin)
msfile.load_key(password="abcd")
fout = open("uriage-decrypt.xlsx","wb")
msfile.decrypt(fout)

book = xl.load_workbook("uriage-decrypt.xlsx")
sheet = book.active
for row in sheet["a2:f99"]:
    values = [v.value for v in row]
    if values[0] is None: break
    print(values)