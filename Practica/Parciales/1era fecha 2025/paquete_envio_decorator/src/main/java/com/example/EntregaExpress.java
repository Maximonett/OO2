package com.example;

public class EntregaExpress extends ServicioAdicional {

    public EntregaExpress(Envio envio) {
        super(envio);
    }

    @Override
    public double costoEnvio() {
        return envio.costoEnvio()
                + envio.getValorDeclarado() * 0.50;
    }

    @Override
    public String descripcion() {
        return envio.descripcion() + " entrega express";
    }

    @Override
    public double getValorDeclarado() {
        return envio.getValorDeclarado();
    }
}
