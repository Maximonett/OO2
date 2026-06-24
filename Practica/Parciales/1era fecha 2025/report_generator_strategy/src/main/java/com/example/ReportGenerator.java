package com.example;

public class ReportGenerator {

    private ReportExporter exporter;
    private ReportSaver saver;

    public ReportGenerator(ReportExporter exporter, ReportSaver saver) {
        this.exporter = exporter;
        this.saver = saver;
    }

    public void generateReport(Document document) {
        exporter.export(document, saver);
    }
}
