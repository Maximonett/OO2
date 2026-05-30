package com.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SugerenciaPorPuntaje implements CriterioSugerencia {

    @Override
    public List<Pelicula> sugerir (Decodificador decodificador){

        return decodificador.getGrilla().stream()

        .filter(p->!decodificador
                .getReproducidas()
                .contains(p)
        )

        .sorted(
            Comparator
            .comparing(Pelicula::getPuntaje)
            .reversed()

            .thenComparing(
                    Pelicula::getAnioEstreno,
                    Comparator.reverseOrder()
            )
        )

        .limit(3)

        .collect(Collectors.toList());

    }
}
