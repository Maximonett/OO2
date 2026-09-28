package com.example;

public class Alerta implements EstadoRiesgo {

    @Override
    public void actualizar(Zona zona, double co2) {

        if (co2 >= 1200) {
            EstadoRiesgo e =new Emergencia();
            zona.cambiarEstado(e);
            e.entrar(zona);

        } else if (co2 < 800 && co2 >= 500) {
            EstadoRiesgo e= new Precaucion();
            zona.cambiarEstado(e);
            e.entrar(zona);

        } else if (co2 < 500) {
            EstadoRiesgo e=new Normal();
            zona.cambiarEstado(e);
            e.entrar(zona);
        }
    }

    @Override
    public void entrar(Zona zona) {

        System.out.println(
            "LOG: La zona ingresó en ALERTA."
        );

        System.out.println(
            "WHATSAPP: Aviso al equipo de respuesta."
        );
    }

    @Override
    public String nombre() {

        return "Alerta";
    }
}