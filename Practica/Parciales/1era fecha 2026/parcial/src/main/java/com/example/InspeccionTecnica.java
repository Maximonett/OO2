package com.example;

public class InspeccionTecnica implements MecanismoMitigacion {

    @Override
    public void activar() {
        System.out.println("activando inspección técnica");
    }
}