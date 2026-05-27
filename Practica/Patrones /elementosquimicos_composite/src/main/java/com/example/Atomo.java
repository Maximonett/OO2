package com.example;

public class Atomo extends ElementoQuimico {
    private final String nombre;
    private final String simbolo;
    private final int pesoAtomico;
    private final int cargaTypica;
    private final Clasificacion clasificacion;

    public Atomo(String nombre,String simbolo,int pesoAtomico,int carga,Clasificacion clasificacion){
        this.nombre=nombre;
        this.simbolo=simbolo;
        this.pesoAtomico=pesoAtomico;
        this.cargaTypica=carga;
        this.clasificacion=clasificacion;
    }

    @Override public String formula(){return simbolo;}

    @Override public int pesoMolecular(){return pesoAtomico;}

    @Override public int carga(){return cargaTypica;}

    @Override public boolean esValido(){return true;} //atomo es siempre valido...

    @Override
    public boolean puedeCombinarseConMetal(){ 
        return clasificacion == Clasificacion.NO_METAL; //si clasificacion es no metal devuelve true si es metal (metal con metal no se puede)
    }

    @Override
    public boolean puedeCombinarseConNoMetal(){ //Siempre es valida sea Metal o No-Metal
        return true;
    }
}
