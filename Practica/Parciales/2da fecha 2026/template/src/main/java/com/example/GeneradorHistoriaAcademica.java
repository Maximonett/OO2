package com.example;

import java.util.Arrays;
import java.util.Comparator;

public class GeneradorHistoriaAcademica extends GeneradorInforme {
    private Alumno alumno;
    private MateriaRendida[] materias;

    public GeneradorHistoriaAcademica(String legajo, RepositorioAcademico repositorio, Exportador exportador) {
        super(legajo, repositorio, exportador);
    }

    @Override
    protected void recuperarDatos() {
        alumno = repositorio.buscarAlumno(legajo);
        materias = repositorio.buscarMateriaRendidas(legajo);
        informe = new Informe("Historia Academica");
    }

    @Override
    protected boolean necesitaTransformacion() {
        return true;
    }

    @Override
    protected void transformarDatos() {
        // ordenar materias por fecha
        Arrays.sort(materias, Comparator.comparing(MateriaRendida::getFecha));
    }

    @Override
    protected void redactarContenido() {
        informe.agregarLinea("===HISTORIA ACADEMICA===");
        informe.agregarLinea("Alumno: " + alumno.getNombre());
        informe.agregarLinea("Legajo: " + alumno.getLegajo());
        informe.agregarLinea("========================");

        for (MateriaRendida materia : materias) {
            informe.agregarLinea("Materia: " + materia.getNombreMateria());
            informe.agregarLinea("Fecha: " + materia.getFecha());
            informe.agregarLinea("Nota: " + materia.getNota());
            informe.agregarLinea("==============================");
        }
    }

    @Override
    protected String obtenerFormatoExportacion() {
        return "PDF";
    }

}
