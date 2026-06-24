package com.example;

public abstract class ServicioAdicional implements Envio {

    protected Envio envio;

    public ServicioAdicional(Envio envio) {
        this.envio = envio;
    }
}
