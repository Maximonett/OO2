package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class PersonajeFactory {
    private static final Map<String, Function<String, Personaje>> builders = new HashMap<>();

    static {
        registrar("GUERRERO", nombre -> new GuerreroBuilder(nombre)
                .construirArmadura()
                .construirArma()
                .construirHabilidades()
                .getPersonaje());
        registrar("ARQUERO", nombre -> new ArqueroBuilder(nombre)
                .construirArmadura()
                .construirArma()
                .construirHabilidades()
                .getPersonaje());
        registrar("MAGO", nombre -> new MagoBuilder(nombre)
                .construirArmadura()
                .construirArma()
                .construirHabilidades()
                .getPersonaje());
        registrar("THOOR", nombre -> new ThoorBuilder(nombre)
                .construirArmadura()
                .construirArma()
                .construirHabilidades()
                .getPersonaje());
    }

    // Metodop para registrar nuevos tipos
    public static void registrar(String tipo, Function<String, Personaje> constructor) {
        builders.put(tipo.toUpperCase(), constructor);
    }

    public Personaje crearPersonaje(String tipo, String nombre) {
        Function<String, Personaje> constructor = builders.get(tipo.toUpperCase());

        if (constructor == null) {
            throw new IllegalArgumentException("Tipo de personaje desconocido: " + tipo);
        }
        return constructor.apply(nombre);
    }

    // Metodo para saber que tipos existen
    public static java.util.Set<String> getTiposDisponibles() {
        return builders.keySet();
    }
}
