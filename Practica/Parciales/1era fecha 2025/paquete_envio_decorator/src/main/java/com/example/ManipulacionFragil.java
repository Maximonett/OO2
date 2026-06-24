package com.example;

public class ManipulacionFragil extends ServicioAdicional {

    public ManipulacionFragil(Envio envio) {
        super(envio);
    }

    @Override
    public double costoEnvio() {
        return envio.costoEnvio();
    }

    @Override
    public String descripcion() {
        return envio.descripcion() + " fragil";
    }

    @Override
    public double getValorDeclarado() {
        return envio.getValorDeclarado();
    }
}
