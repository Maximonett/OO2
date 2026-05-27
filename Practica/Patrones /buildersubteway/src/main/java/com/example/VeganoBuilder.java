package com.example;

public class VeganoBuilder implements SandwichBuilder {
    private Sandwich sandwich;


    @Override
    public void reset(){this.sandwich=new Sandwich();}
    @Override
    public void buildPan(){sandwich.addIngrediente(new Ingrediente("Pan Integral", 100));}
    @Override
    public void buildAderezo(){sandwich.addIngrediente(new Ingrediente("Salsa Criolla", 20));}
    @Override
    public void buildPricipal(){sandwich.addIngrediente(new Ingrediente("Milanesa de Girgolas", 500));}
    @Override
    public void buildAdiciona(){/*Sin adicional*/}
    @Override
    public Sandwich getSandwich(){return this.sandwich; }


}
