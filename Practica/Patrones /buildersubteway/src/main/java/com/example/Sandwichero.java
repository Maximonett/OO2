package com.example;

public class Sandwichero {
    public void prepararSandwich(SandwichBuilder builder){
        builder.reset();
        builder.buildPan();
        builder.buildAderezo();
        builder.buildPrincipal();
        builder.buildAdicional();
    }
}