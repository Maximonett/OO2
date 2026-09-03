package com.example;

public class GeneradorCertificadoRegular extends GeneradorInforme {
    private Alumno alumno;
    private int cantidadMaterias;

    public GeneradorCertificadoRegular(String legajo, RepositorioAcademico repositorio, Exportador exportador) {
        super(legajo, repositorio, exportador);
    }

    @Override
    protected void recuperarDatos() {
        alumno = repositorio.buscarAlumno(legajo);
        MateriaRendida[] materias = repositorio.buscarMateriaRendidas(legajo);
        cantidadMaterias = materias.length;
        informe = new Informe("Certificado de aLumno Regular");
    }

    @Override
    protected void redactarContenido() {
        informe.agregarLinea("===CERTIFICADO DE ALUMNO REGULAR");
        informe.agregarLinea("Nombre: " + alumno.getNombre());
        informe.agregarLinea("Legajo: " + alumno.getLegajo());
        informe.agregarLinea("Carrera: " + alumno.getCarrera());
        informe.agregarLinea("Condicion: " + alumno.getCondicicon());
        informe.agregarLinea("Materias Rendidas: " + cantidadMaterias);
    }

    @Override
    protected String obtenerFormatoExportacion() {
        return "PDF";
    }

}
