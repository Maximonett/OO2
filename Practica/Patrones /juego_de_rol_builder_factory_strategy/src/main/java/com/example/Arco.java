package com.example;

public class Arco extends Arma {

    public Arco() {
        this.nombre = "Arco";
    }

    @Override
    public int calcularDano(Armadura armadura) {
        if (armadura instanceof ArmaduraDeCuero)
            return 5;
        if (armadura instanceof ArmaduraDeHierro)
            return 3;
        if (armadura instanceof ArmaduraDeAcero)
            return 2;
        return 0;
    }
}
