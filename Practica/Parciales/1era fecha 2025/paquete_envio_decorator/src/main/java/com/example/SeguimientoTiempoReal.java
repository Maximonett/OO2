package com.example;

public class SeguimientoTiempoReal extends ServicioAdicional {

    public SeguimientoTiempoReal(Envio envio) {
        super(envio);
    }

    @Override
    public double costoEnvio() {
        return envio.costoEnvio() + 2000;
    }

    @Override
    public String descripcion() {
        return envio.descripcion();
    }

    @Override
    public double getValorDeclarado() {
        return envio.getValorDeclarado();
    }
}
