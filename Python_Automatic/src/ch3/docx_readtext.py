import docx

doc = docx.Document("letter.docx")

for p in doc.paragraphs:
    print(p.text)