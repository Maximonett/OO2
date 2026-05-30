package com.example;
import java.util.List;

/*STRATEGY*/

public interface CriterioSugerencia {
    
    List<Pelicula> sugerir(Decodificador decodificador);    
}
