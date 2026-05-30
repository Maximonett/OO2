package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaPorNovedad implements CriterioSugerencia {
    
    @Override
    public List<Pelicula> sugerir(Decodificador decodificador){

        return decodificador.getGrilla().stream()

            .filter(p->!decodificador
                .getReproducidas()
                .contains(p)
            )
            .sorted(Comparator 
                .comparing(Pelicula::getAnioEstreno)
                .reversed()
            )
            .limit(3)

            .collect(Collectors.toList());
    }
}
