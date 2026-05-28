package com.example;

public class SinTaccBuilder implements SandwichBuilder {
    private Sandwich sandwich;


    @Override
    public void reset(){this.sandwich=new Sandwich();}
    @Override
    public void buildPan(){sandwich.addIngrediente(new Ingrediente("Pan de Chipa", 150));}
    @Override
    public void buildAderezo(){sandwich.addIngrediente(new Ingrediente("Salsa Tartara", 18));}
    @Override
    public void buildPrincipal(){sandwich.addIngrediente(new Ingrediente("Carne de Pollo", 250));}
    @Override
    public void buildAdicional(){sandwich.addIngrediente(new Ingrediente("Verduras grilladas", 200));}
    @Override
    public Sandwich getSandwich(){return this.sandwich; }


}
