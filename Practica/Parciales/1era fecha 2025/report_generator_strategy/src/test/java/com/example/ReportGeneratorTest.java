package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReportGeneratorTest {

    @BeforeEach
    void setUp() {
        document = new Document("informe");
        document.addAuthor("Carlos");
        document.addAuthor("Ana");

        saver = new ReportSaver();

        generatorPDF = new ReportGenerator(new PDFExporter(), saver);
        generatorXLS = new ReportGenerator(new XLSExporter(), saver);
    }

    @Test
    void testPDF() {
        generatorPDF.generateReport(document);
    }

    @Test
    void testXLS() {
        generatorXLS.generateReport(document);
    }
}
