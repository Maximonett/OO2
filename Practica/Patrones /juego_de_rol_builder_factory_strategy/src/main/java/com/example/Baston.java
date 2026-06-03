package com.example;

public class Baston extends Arma {
    public Baston() {
        this.nombre = "Baston";
    }

    public int calcularDano(Armadura armadura) {
        if (armadura instanceof ArmaduraDeCuero)
            return 2;
        if (armadura instanceof ArmaduraDeHierro)
            return 1;
        if (armadura instanceof ArmaduraDeAcero)
            return 1;
        return 0;
    }

}
