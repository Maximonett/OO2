package ar.edu.unlp.info.oo2.biblioteca;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ExporterTest {
    private Biblioteca biblioteca;
    private Socio socio;

    @BeforeEach
    void setUp() {
        biblioteca = new Biblioteca();
        socio = new Socio("Elliot Alderson", "elliot@fsociety.com", "404");
        biblioteca.agregarSocio(socio);
    }

    @Test
    void testJSONSimpleAdapter() {
        biblioteca.setExporter(new JSONSimpleAdapter());
        String resultado = biblioteca.exportarSocios();
        
        // Verificamos que sea un JSON válido (contiene los datos clave)
        assertTrue(resultado.contains("\"nombre\":\"Elliot Alderson\""));
        assertTrue(resultado.startsWith("[{"));
        assertTrue(resultado.endsWith("}]"));
    }

    @Test
    void testJacksonAdapter() {
        biblioteca.setExporter(new JacksonAdapter());
        String resultado = biblioteca.exportarSocios();
        
        assertTrue(resultado.contains("elliot@fsociety.com"));
    }
}
