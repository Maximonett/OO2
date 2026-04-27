package ar.edu.unlp.info.oo2.biblioteca;

import java.util.ArrayList;
import java.util.List; 

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class VoorheesExporterTest {

    @Test
	public void testExportarListaVacia() {
		Biblioteca biblioteca = new Biblioteca();
		String resultado = biblioteca.exportarSocios();
		assertEquals("[]", resultado);
	}

    @Test
    public void testExportarUnSocio() {
        VoorheesExporter exporter = new VoorheesExporter();    
        Socio socio = new Socio("Juan Perez", "juan.perez@email.com", "12345");
        List<Socio> socios = new ArrayList<>();

        socios.add(socio); 

        String resultado = exporter.exportar(socios);

        //verificar que el resultado es el esperado

        assertTrue(resultado.contains("\"nombre\": \"Juan Perez\""));
        assertTrue(resultado.contains("\"email\": \"juan.perez@email.com\""));
        assertTrue(resultado.contains("\"legajo\": \"12345\""));

        //verificamos que abra con corchete y cierre con corchete
        assertTrue(resultado.startsWith("["));
        assertTrue(resultado.endsWith("]"));
    }
}
