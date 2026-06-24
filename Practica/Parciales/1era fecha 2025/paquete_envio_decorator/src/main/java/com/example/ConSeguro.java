package com.example;

public class ConSeguro extends ServicioAdicional {

    public ConSeguro(Envio envio) {
        super(envio);
    }

    @Override
    public double costoEnvio() {
        return envio.costoEnvio()
                + envio.getValorDeclarado() * 0.20;
    }

    @Override
    public String descripcion() {
        return envio.descripcion() + " con seguro";
    }

    @Override
    public double getValorDeclarado() {
        return envio.getValorDeclarado();
    }
}
