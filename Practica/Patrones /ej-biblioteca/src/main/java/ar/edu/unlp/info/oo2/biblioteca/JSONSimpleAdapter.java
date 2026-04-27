package ar.edu.unlp.info.oo2.biblioteca;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * Rol: Adapter
 * Esta clase adapta la librería JSON.simple a la interfaz Exporter.
 */


public class JSONSimpleAdapter implements Exporter {

    @Override
    public String exportar(List<Socio> socios) {
        // JSONArray con todas mayúsculas después de 'Json'
        JSONArray listaJson = new JSONArray(); 

        for (Socio socio : socios) {
            // JSONObject con todas mayúsculas después de 'Json'
            JSONObject jsonObject = new JSONObject(); 
            
            jsonObject.put("nombre", socio.getNombre());
            jsonObject.put("email", socio.getEmail());
            jsonObject.put("legajo", socio.getLegajo());
            
            listaJson.add(jsonObject);
        }
        
        // toJSONString() es el método de esta librería para obtener el texto
        return listaJson.toJSONString(); 
    }
}

