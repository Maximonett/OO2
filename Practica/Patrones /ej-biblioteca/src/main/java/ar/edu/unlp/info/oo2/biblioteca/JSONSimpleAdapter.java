package ar.edu.unlp.info.oo2.biblioteca;

// Imports específicos de org.json.simple
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import java.util.List;

public class JSONSimpleAdapter implements Exporter {

    @Override
    public String exportar(List<Socio> socios) {
        // 1. Creamos el arreglo JSON principal
        JSONArray listaJson = new JSONArray(); 
        
        // 2. Iteramos sobre la lista de socios
        for (Socio socio : socios) {
            // 3. Creamos un objeto JSON por cada socio
            JSONObject jsonObject = new JSONObject();
            
            // 4. Mapeamos manualmente los atributos
            jsonObject.put("nombre", socio.getNombre());
            jsonObject.put("email", socio.getEmail());
            jsonObject.put("legajo", socio.getLegajo());
            
            // 5. Agregamos el objeto al arreglo
            listaJson.add(jsonObject);
        }
        
        // 6. Convertimos el arreglo completo a String
        return listaJson.toJSONString();
    }
}