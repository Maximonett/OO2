package com.example;

import java.util.ArrayList;
import java.util.List;

public class MagoBuilder implements PersonajeBuilder {
    private String nombre;
    private Armadura armadura;
    private Arma arma;
    private List<Habilidad> habilidades;

    public MagoBuilder(String nombre) {
        this.nombre = nombre;
        this.habilidades = new ArrayList<>();
    }

    @Override
    public PersonajeBuilder construirArmadura() {
        this.armadura = new ArmaduraDeCuero();
        return this;
    }

    @Override
    public PersonajeBuilder construirArma() {
        this.arma = new Baston();
        return this;
    }

    @Override
    public PersonajeBuilder construirHabilidades() {
        this.habilidades.add(new Magia());
        this.habilidades.add(new CombateADistancia());
        return this;
    }

    @Override
    public Personaje getPersonaje() {
        return new Personaje(nombre, armadura, arma, habilidades);
    }

}
