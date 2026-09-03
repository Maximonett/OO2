package com.example;

public abstract class GeneradorInforme {
    protected String legajo;
    protected RepositorioAcademico repositorio;
    protected Exportador exportador;
    protected Informe informe;

    public GeneradorInforme(String legajo, RepositorioAcademico repositorio, Exportador exportador) {
        this.legajo = legajo;
        this.repositorio = repositorio;
        this.exportador = exportador;
    }

    // =========TEMPLATE METHOD============

    public final Archivo generar() {
        recuperarDatos();

        if (necesitaTransformacion()) {
            transformarDatos();
        }
        redactarContenido();
        return exportar();
    }

    // ====METODOS ABSTRACTOS (deben ser implementados por las subclases)=====

    protected abstract void recuperarDatos();

    protected abstract void redactarContenido();

    protected abstract String obtenerFormatoExportacion();

    // ===METODOS HOOKS (metodos gancho con implementacion por defecto se puede
    // modificar!!!!)======

    protected boolean necesitaTransformacion() {
        return false;
    }

    protected void transformarDatos() {
        // Implementacion vacia por defecto si lo necesita lo hace sino, no.
    }

    // ======= METODO DE EXPORTACION========
    protected Archivo exportar() {
        String formato = obtenerFormatoExportacion();
        if (formato.equals("PDF")) {
            return exportador.aPDF(informe);
        } else if (formato.equals("CSV")) {
            return exportador.aCSV(informe);
        }
        throw new IllegalStateException("Formato no soportado: " + formato);
    }

}
