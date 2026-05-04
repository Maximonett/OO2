package com.example;

public class Hoja implements Topografia{
    private double proporcionDeAgua;

    public Hoja(double proporcion){
        this.proporcionDeAgua=proporcion;
    }

    public double calcularProporcionAgua(){
        return this.proporcionDeAgua;
    }
    public boolean esIgualAMixta(Mixta mixta){
        return false;

    }
    public boolean equal(Object topo){
        return ((Topografia)topo)
            .calcularProporcionAgua()==this.calcularProporcionAgua();
    }
    
    @Override
	public boolean esIgualAPantano(Pantano pantano) {
		// Una Hoja genérica (Agua/Tierra) nunca es igual a un Pantano
		return false;
	}

}
