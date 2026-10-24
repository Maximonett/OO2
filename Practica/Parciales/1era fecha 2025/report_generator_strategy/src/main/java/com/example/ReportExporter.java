package com.example;

public interface ReportExporter {

    void export(Document document, ReportSaver saver);
}
