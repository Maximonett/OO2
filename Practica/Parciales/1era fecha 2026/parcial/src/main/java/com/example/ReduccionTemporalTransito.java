package com.example;

public class ReduccionTemporalTransito implements MecanismoMitigacion {

    @Override
    public void activar() {
        System.out.println("activando reducción temporal del tránsito");
    }
}
