package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaPorSimilaridad implements CriterioSugerencia{
    
    @Override
    public List<Pelicula> sugerir(Decodificador decodificador){
        return decodificador.getReproducidas().stream()
                .flatMap(p->p.getSimilares().stream()) // en ves de usar map que me entregaria una lista de listas , flatMap unifica las dos en una
                
                .distinct() //elimino dublicados 
                
                .filter(p->!(decodificador.getReproducidas().contains(p))) // elimina peliculas reproducidas

                .sorted(
                    Comparator.comparing(Pelicula::getAnioEstreno)
                        .reversed()
                ) // ordena por año de estreno de mayor a menor     
                
                .limit(3)

                .collect(Collectors.toList());
            
    }
}
