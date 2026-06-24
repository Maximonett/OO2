package com.example;

public class Main {
    public static void main(String[] args) {

        Envio envio = new EntregaExpress(
                new ConSeguro(
                        new Paquete(
                                20000,
                                "Calle 123",
                                "Juan Perez",
                                "Caja de libros")));

        System.out.println(envio.costoEnvio());
        System.out.println(envio.descripcion());
    }
}
