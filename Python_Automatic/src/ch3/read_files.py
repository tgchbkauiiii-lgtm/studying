import glob as g
import openpyxl as x

target_dir = "../../salesbooks"
save_file = "matome.xlsx"

def read_files():
    book = x.Workbook()
    main_sheet = book.active
    enumfiles(main_sheet)
    book.save(save_file)

def enumfiles(main_sheet):
    files = g.glob(target_dir + "/*.xlsx")
    for fname in files:
        read_book(main_sheet, fname)

def read_book(main_sheet, fname):
    print("read:",fname)
    book = x.load_workbook(fname, data_only=True)
    sheet = book.active
    rows = sheet["a4:f999"]
    for row in rows:
        values = [cell.value for cell in row]
        if values[0] is None: break
        print(values)
        main_sheet.append(values)

if __name__ == "__main__":
    read_files()