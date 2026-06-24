package com.example;

public class PDFExporter implements ReportExporter {

    @Override
    public void export(Document document, ReportSaver saver) {

        DocumentFile docFile = new DocumentFile();
        docFile.setTitle(document.getTitle());

        String authors = "";
        for (String author : document.getAuthors()) {
            authors += ", " + author;
        }
        docFile.setAuthor(authors);

        docFile.setContentType("application/pdf");
        docFile.setPageSize("A4");

        PDFExporterEngine engine = new PDFExporterEngine();
        byte[] content = engine.generatePDFFile(document);

        docFile.setContent(content);

        saver.save(docFile);
    }
}
