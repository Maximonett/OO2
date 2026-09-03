package com.example;

public class Exportador {
    public Archivo aPDF(Informe informe) {
        return new Archivo("PDF" + informe.getContenido(), "PDF");
    }

    public Archivo aCSV(Informe informe) {
        return new Archivo("CSV" + informe.getContenido(), "CSV");
    }
}
