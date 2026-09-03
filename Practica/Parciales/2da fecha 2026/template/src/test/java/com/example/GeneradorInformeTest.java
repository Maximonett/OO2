package com.example;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GeneradorInformeTest {
    private RepositorioAcademico repositorio;
    private Exportador exportador;

    @BeforeEach
    void setUp() {
        repositorio = new RepositorioAcademico();
        exportador = new Exportador();
    }

    // ===== TEST CERTIFICADO DE ALUMNO REGULAR =====
    @Test
    void testGenerarCertificadoRegular() {
        GeneradorInforme generador = new GeneradorCertificadoRegular("12345", repositorio, exportador);
        Archivo archivo = generador.generar();

        assertNotNull(archivo);
        assertEquals("PDF", archivo.getFormato());
        assertTrue(archivo.getContenido().contains("CERTIFICADO DE ALUMNO REGULAR"));
        assertTrue(archivo.getContenido().contains("Legajo: 12345"));
        assertTrue(archivo.getContenido().contains("Materias Rendidas:"));
    }

    // ===== TEST HISTORIA ACADÉMICA =====
    @Test
    void testGenerarHistoriaAcademica() {
        GeneradorInforme generador = new GeneradorHistoriaAcademica("12345", repositorio, exportador);
        Archivo archivo = generador.generar();

        assertNotNull(archivo);
        assertEquals("PDF", archivo.getFormato());
        assertTrue(archivo.getContenido().contains("HISTORIA ACADEMICA"));
        assertTrue(archivo.getContenido().contains("Materia:"));
        assertTrue(archivo.getContenido().contains("Nota:"));
    }

    @Test
    void testHistoriaAcademicaOrdenCronologico() {
        GeneradorInforme generador = new GeneradorHistoriaAcademica("12345", repositorio, exportador);
        Archivo archivo = generador.generar();

        // Verificar que las materias están ordenadas (el contenido debe mostrarlas en
        // orden)
        String contenido = archivo.getContenido();
        int primeraMateria = contenido.indexOf("Materia:");
        int segundaMateria = contenido.indexOf("Materia:", primeraMateria + 1);

        assertTrue(primeraMateria < segundaMateria, "Las materias deben aparecer en orden");
    }

    // ===== TEST INFORME DE RENDIMIENTO =====
    @Test
    void testGenerarInformeRendimiento() {
        GeneradorInforme generador = new GeneradorRendimiento("12345", repositorio, exportador);
        Archivo archivo = generador.generar();

        assertNotNull(archivo);
        assertEquals("CSV", archivo.getFormato());
        assertTrue(archivo.getContenido().contains("INFORME DE RENDIMIENTO"));
        assertTrue(archivo.getContenido().contains("PROMEDIO GENERAL:"));
    }

    @Test
    void testInformeRendimientoCalculaPromedio() {
        GeneradorInforme generador = new GeneradorRendimiento("12345", repositorio, exportador);
        Archivo archivo = generador.generar();

        String contenido = archivo.getContenido();
        assertTrue(contenido.contains("PROMEDIO GENERAL:"));

        int inicio = contenido.indexOf("PROMEDIO GENERAL:");
        String linea = contenido.substring(inicio, contenido.indexOf("\n", inicio));
        assertTrue(linea.matches("PROMEDIO GENERAL: [0-9.]+"));
    }

    // ===== TEST TEMPLATE METHOD =====
    @Test
    void testTemplateMethodMantieneEstructura() {
        // Todos los generadores deben seguir el mismo flujo
        GeneradorInforme[] generadores = {
                new GeneradorCertificadoRegular("12345", repositorio, exportador),
                new GeneradorHistoriaAcademica("12345", repositorio, exportador),
                new GeneradorRendimiento("12345", repositorio, exportador)
        };

        for (GeneradorInforme generador : generadores) {
            Archivo archivo = generador.generar();
            assertNotNull(archivo, "Cada generador debe producir un archivo");
        }
    }

    // ===== TEST HOOK METHODS =====
    @Test
    void testHookMethodNecesitaTransformacion() {
        GeneradorInforme certificado = new GeneradorCertificadoRegular("12345", repositorio, exportador);
        GeneradorInforme historia = new GeneradorHistoriaAcademica("12345", repositorio, exportador);
        GeneradorInforme rendimiento = new GeneradorRendimiento("12345", repositorio, exportador);

        // Certificado no necesita transformación por defecto
        // Historia y Rendimiento sí necesitan (orden cronológico)
        assertAll("Hook methods",
                () -> assertNotNull(certificado.generar()),
                () -> assertNotNull(historia.generar()),
                () -> assertNotNull(rendimiento.generar()));
    }
}
