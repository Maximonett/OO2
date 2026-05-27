package com.example;

public class ClasicoBuilder implements SandwichBuilder {
    private Sandwich sandwich;


    @Override
    public void reset(){this.sandwich=new Sandwich();}
    @Override
    public void buildPan(){sandwich.addIngrediente(new Ingrediente("Pan Briosche", 100));}
    @Override
    public void buildAderezo(){sandwich.addIngrediente(new Ingrediente("Aderezo a base de Mayonesa", 20));}
    @Override
    public void buildPricipal(){sandwich.addIngrediente(new Ingrediente("Carne de Terner", 300));}
    @Override
    public void buildAdiciona(){sandwich.addIngrediente(new Ingrediente("Tomate", 80));}
    @Override
    public Sandwich getSandwich(){return this.sandwich; }


}
