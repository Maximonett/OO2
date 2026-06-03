package com.example;

public class Martillo extends Arma {
    public Martillo() {
        this.nombre = "Martillo";
    }

    @Override
    public int calcularDano(Armadura armadura) {
        if (armadura instanceof ArmaduraDeCuero)
            return 9;
        if (armadura instanceof ArmaduraDeHierro)
            return 6;
        if (armadura instanceof ArmaduraDeAcero)
            return 4;
        return 0;
    }
}
