package com.example;

import java.util.ArrayList;
import java.util.List;

public class ThoorBuilder implements PersonajeBuilder {
    private String nombre;
    private Armadura armadura;
    private Arma arma;
    private List<Habilidad> habilidades;

    public ThoorBuilder(String nombre) {
        this.nombre = nombre;
        this.habilidades = new ArrayList<>();
    }

    @Override
    public PersonajeBuilder construirArmadura() {
        this.armadura = new ArmaduraDeHierro();
        return this;
    }

    @Override
    public PersonajeBuilder construirArma() {
        this.arma = new Martillo();
        return this;
    }

    @Override
    public PersonajeBuilder construirHabilidades() {
        this.habilidades.add(new LanzarRayos());
        this.habilidades.add(new CombateADistancia());
        return this;
    }

    @Override
    public Personaje getPersonaje() {
        return new Personaje(nombre, armadura, arma, habilidades);
    }

}
