package com.example;

import java.util.ArrayList;
import java.util.List;

public class Mixta implements Topografia {
    private List<Topografia> topografias; 
    
    public Mixta(){
        this.topografias=new ArrayList<>();
    }

    public void add(Topografia topo){
        if (this.topografias.size()<4){
            this.topografias.add(topo);
        }
    }


    @Override
    public double calcularProporcionAgua(){
        return (
            this.topografias.stream()
                .mapToDouble(topo->topo.calcularProporcionAgua())
                .sum())/4;
    }

    @Override
    public boolean esIgualAMixta(Mixta topo){
        return (this.topografias.equals(topo.topografias));
    }

    @Override
    public boolean equal(Object topo){
        return ((Topografia)topo).esIgualAMixta(this);
    }

    @Override
	public boolean esIgualAPantano(Pantano pantano) {
		// Una Hoja genérica (Agua/Tierra) nunca es igual a un Pantano
		return false;
	}

}
