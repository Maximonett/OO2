package com.example;
// =======================================
// CONCRETE BUILDER
// Construye el composite internamente
// =======================================
public class ProductoFinancieroBuilder implements ProductoBuilder{
    private ProductoCombinado producto;

    public ProductoFinancieroBuilder(){
        producto=new ProductoCombinado();
    }

    @Override
    public ProductoBuilder agregarCompraDolar(){
        producto.agregarProducto(new CompraDolares());
        return this;
    }
    @Override 
    public ProductoBuilder agregarCompraPesos(){
        producto.agregarProducto(new CompraPesos());
        return this;
    }

    @Override
    public ProductoBuilder agregarPlazoFijo(int dias,double interes){
        producto.agregarProducto(new PlazoFijo(dias, interes));
        return this;
    }

    @Override 
    public ProductoBuilder agregarBonoBajoRiesgo(int parking){
        producto.agregarProducto(new BonoBajoRiesgo(parking));
        return this;
    }

    @Override 
    public ProductoBuilder agregarBonoAltoRiesgo(int parking){
        producto.agregarProducto(new BonoAltoRiesgo(parking));
        return this;
    }

    @Override 
    public ProductoFinanciero build(){
        return producto;
    }
}
