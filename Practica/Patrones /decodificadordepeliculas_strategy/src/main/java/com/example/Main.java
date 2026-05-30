package com.example;

public class Main {

    public static void main(String[] args) {

        Pelicula thor =
                new Pelicula("Thor", 7.9, 2007);

        Pelicula capitan =
                new Pelicula("Capitan America", 7.8, 2016);

        Pelicula ironman =
                new Pelicula("Iron Man", 7.9, 2010);

        Pelicula dunkirk =
                new Pelicula("Dunkirk", 7.9, 2017);

        Pelicula rocky =
                new Pelicula("Rocky", 8.1, 1976);

        Pelicula rambo =
                new Pelicula("Rambo", 7.8, 1979);

        thor.agregarSimilar(capitan);
        thor.agregarSimilar(ironman);
        rocky.agregarSimilar(rambo);

        Decodificador deco = new Decodificador();

        deco.agregarPelicula(thor);
        deco.agregarPelicula(capitan);
        deco.agregarPelicula(ironman);
        deco.agregarPelicula(dunkirk);
        deco.agregarPelicula(rocky);
        deco.agregarPelicula(rambo);

        deco.reproducir(thor);
        deco.reproducir(rocky);

        deco.setCriterio(new SugerenciaPorSimilaridad());

        System.out.println("Similaridad:");

        deco.sugerir()
                .forEach(p -> System.out.println(p.getTitulo()));

        deco.setCriterio(new SugerenciaPorPuntaje());

        System.out.println("Puntaje:");

        deco.sugerir()
                .forEach(p -> System.out.println(p.getTitulo()));
    }
}
