package com.example;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReportGeneratorTest {

    private Document document;
    private ReportSaver saver;
    private ReportGenerator generatorPDF;
    private ReportGenerator generatorXLS;

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
        assertDoesNotThrow(() -> generatorPDF.generateReport(document));
    }

    @Test
    void testXLS() {
        assertDoesNotThrow(() -> generatorXLS.generateReport(document));
    }
}
