package com.example;

public class KetoBuilder implements SandwichBuilder {
    private Sandwich sandwich;


    @Override
    public void reset(){this.sandwich=new Sandwich();}
    @Override
    public void buildPan(){sandwich.addIngrediente(new Ingrediente("Pan de almendras", 180));}
    @Override
    public void buildAderezo(){sandwich.addIngrediente(new Ingrediente("Mayonesa de oliva", 20));}
    @Override
    public void buildPricipal(){sandwich.addIngrediente(new Ingrediente("Doble hamburguesa de carne", 450));}
    @Override
    public void buildAdiciona(){sandwich.addIngrediente(new Ingrediente("Huevo frito y panceta", 150));}
    @Override
    public Sandwich getSandwich(){return this.sandwich; }


}
