package ar.edu.unlp.info.oo2.biblioteca;

// Imports específicos de com.fasterxml.jackson
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.List;

public class JacksonAdapter implements Exporter {

    @Override
    public String exportar(List<Socio> socios) {
        // 1. Creamos el ObjectMapper (el "cerebro" de Jackson)
        ObjectMapper mapper = new ObjectMapper();
        
        try {
            // 2. Jackson es mágico: convierte la lista y los objetos
            // internamente usando Reflection, sin mapeo manual.
            return mapper.writeValueAsString(socios);
            
        } catch (JsonProcessingException e) {
            // 3. Jackson obliga a manejar esta excepción
            e.printStackTrace();
            // Devolvemos un JSON vacío en caso de error
            return "[]"; 
        }
    }
}