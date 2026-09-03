package com.example;

import java.util.Arrays;
import java.util.Comparator;

public class GeneradorRendimiento extends GeneradorInforme {
    private Alumno alumno;
    private MateriaRendida[] materias;
    private double promedio;

    public GeneradorRendimiento(String legajo, RepositorioAcademico repositorio, Exportador exportador) {
        super(legajo, repositorio, exportador);
    }

    @Override
    protected void recuperarDatos() {
        alumno = repositorio.buscarAlumno(legajo);
        materias = repositorio.buscarMateriaRendidas(legajo);
        calcularPromedio();
        informe = new Informe("Infrome de Rendimiento");
    }
    // ===CALCULO EL PROMEDIO CON STREAM

    private void calcularPromedio() {
        promedio = Arrays.stream(materias)
                .mapToDouble(MateriaRendida::getNota)
                .average()
                .orElse(0);
    }

    @Override
    protected boolean necesitaTransformacion() {
        return true;
    }

    @Override
    protected void transformarDatos() {
        Arrays.sort(materias, Comparator.comparing(MateriaRendida::getFecha));
    }

    @Override
    protected void redactarContenido() {
        informe.agregarLinea("INFORME DE RENDIMIENTO");
        informe.agregarLinea("Alumno: " + alumno.getNombre());
        informe.agregarLinea("Legajo: " + alumno.getLegajo());
        informe.agregarLinea("=======================");

        for (MateriaRendida materia : materias) {
            informe.agregarLinea(materia.getNombreMateria() + "," +
                    materia.getFecha() + "," + materia.getNota());
        }

        informe.agregarLinea("");
        informe.agregarLinea("PROMEDIO GENERAL: " + promedio);
    }

    @Override
    protected String obtenerFormatoExportacion() {
        return "CSV";
    }

}
