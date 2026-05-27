package com.example;

public class VegetarianoBuilder implements SandwichBuilder{
    private Sandwich sandwich;

    @Override
    public void reset(){this.sandwich=new Sandwich();}
    @Override
    public void buildPan(){sandwich.addIngrediente(new Ingrediente("Pan con Semillas", 120));}
    @Override
    public void buildAderezo(){/*Sin Aderezo*/}
    @Override
    public void buildPricipal(){sandwich.addIngrediente(new Ingrediente("Provoleta Grillada", 200));}
    @Override
    public void buildAdiciona(){sandwich.addIngrediente(new Ingrediente("Berenjena al escabeche", 100));}
    @Override
    public Sandwich getSandwich(){return this.sandwich; }

}
