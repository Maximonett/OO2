package ar.edu.unlp.info.oo2.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class BibliotecaTest {
	// Para completar
	@Test
	void testCambioDeEstartegia(){

		Biblioteca biblioteca = new Biblioteca();
		//creamos un Exportador para probar
		Exporter mockExporter= socio->"Formato de prueba";
		biblioteca.setExporter(mockExporter);
		assertEquals("Formato de prueba", biblioteca.exportarSocios());


	}



}
