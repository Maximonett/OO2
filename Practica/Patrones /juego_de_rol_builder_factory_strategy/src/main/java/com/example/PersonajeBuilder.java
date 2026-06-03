package com.example;

public interface PersonajeBuilder {
    PersonajeBuilder construirArmadura();

    PersonajeBuilder construirArma();

    PersonajeBuilder construirHabilidades();

    Personaje getPersonaje();
}
