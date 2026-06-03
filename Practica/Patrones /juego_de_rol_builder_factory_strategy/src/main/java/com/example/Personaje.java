package com.example;

import java.util.List;

public class Personaje {
    private String nombre;
    private Armadura armadura;
    private Arma arma;
    private List<Habilidad> habilidades;
    private int puntosDeVida;

    public Personaje(String nombre, Armadura armadura, Arma arma, List<Habilidad> habilidades) {
        this.nombre = nombre;
        this.armadura = armadura;
        this.arma = arma;
        this.habilidades = habilidades;
        this.puntosDeVida = 100;
    }

    public void recibirAtaque(Personaje atacante) {
        if (!this.estaVivo()) {
            System.out.println(this.nombre + " esta derrotado");
            return;
        }
        int dano = atacante.arma.calcularDano(this.armadura);
        this.puntosDeVida -= dano;

        System.out.println(atacante.nombre + " ataca a " + this.nombre +
                " con " + atacante.arma.getNombre() +
                " causando " + dano + " de daño");

        if (this.puntosDeVida <= 0) {
            this.puntosDeVida = 0;
            System.out.println(this.nombre + " ha sido derrotado!");
        } else {
            System.out.println(this.nombre + " le quedan " + this.puntosDeVida + " puntos de vida");
        }
    }

    public boolean estaVivo() {
        return puntosDeVida > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public Armadura getArmadura() {
        return armadura;
    }

    public Arma getArma() {
        return arma;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public int getPuntosDeVida() {
        return puntosDeVida;
    }

}
