package com.example;

public abstract class ElementoQuimico {
    
    public abstract String formula();
    public abstract int pesoMolecular();
    public abstract int carga();
    public abstract boolean esValido();



    //Doble Dispatch
    public abstract boolean puedeCombinarseConMetal();
    public abstract boolean puedeCombinarseConNoMetal();

}
