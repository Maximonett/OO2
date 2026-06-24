package com.example;

public class XLSExporter implements ReportExporter {

    @Override
    public void export(Document document, ReportSaver saver) {

        DocumentFile docFile = new DocumentFile();
        docFile.setTitle(document.getTitle());

        String authors = "";
        for (String author : document.getAuthors()) {
            authors += ", " + author;
        }
        docFile.setAuthor(authors);

        docFile.setContentType("application/vnd.ms-excel");
        docFile.setSheetName(document.getSubtitle());

        ExcelWriter writer = new ExcelWriter();
        byte[] content = writer.generateExcelFile(document);

        docFile.setContent(content);

        saver.save(docFile);
    }
}
