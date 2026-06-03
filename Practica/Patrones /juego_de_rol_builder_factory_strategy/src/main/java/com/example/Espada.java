package com.example;

public class Espada extends Arma {
    public Espada() {
        this.nombre = "Espada";
    }

    @Override
    public int calcularDano(Armadura armadura) {
        if (armadura instanceof ArmaduraDeCuero)
            return 8;
        if (armadura instanceof ArmaduraDeHierro)
            return 5;
        if (armadura instanceof ArmaduraDeAcero)
            return 3;
        return 0;
    }
}
