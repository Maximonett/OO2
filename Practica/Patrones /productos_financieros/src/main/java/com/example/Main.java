package com.example;

public class Main {

    public static void main(String[] args) {

        Cliente cliente = new Cliente(new Gold());

        DirectorProducto director = new DirectorProducto();

        ProductoFinanciero producto = director.crearProducto1(cliente.getMembresia());

        double resultado = producto.retornoInversion(1000);
        System.out.println("------------");
        System.out.println("------------");
        System.out.print("Resultado:$ ");
        System.out.println(resultado);
        System.out.println("------------");
        System.out.println("------------");
    }
}
