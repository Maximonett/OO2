package com.example;

import java.util.ArrayList;
import java.util.List;

public class GuerreroBuilder implements PersonajeBuilder {
    private String nombre;
    private Armadura armadura;
    private Arma arma;
    private List<Habilidad> habilidades;

    public GuerreroBuilder(String nombre) {
        this.nombre = nombre;
        this.habilidades = new ArrayList<>();
    }

    @Override
    public PersonajeBuilder construirArma() {
        this.arma = new Espada();
        return this;
    }

    @Override
    public PersonajeBuilder construirArmadura() {
        this.armadura = new ArmaduraDeAcero();
        return this;
    }

    @Override
    public PersonajeBuilder construirHabilidades() {
        habilidades.add(new CombateCuerpoACuerpo());
        return this;
    }

    @Override
    public Personaje getPersonaje() {
        return new Personaje(nombre, armadura, arma, habilidades);
    }
}
