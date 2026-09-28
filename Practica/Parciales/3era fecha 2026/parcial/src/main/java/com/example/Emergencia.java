package com.example;

public class Emergencia implements EstadoRiesgo {

    @Override
    public void actualizar(Zona zona, double co2) {

        if (co2 < 500) {
            EstadoRiesgo e=new Normal();
            zona.cambiarEstado(e);
            e.entrar(zona);

        } else if (co2 < 800) {
            EstadoRiesgo e=new Precaucion();
            zona.cambiarEstado(e);
            e.entrar(zona);

        } else if (co2 < 1200) {
            EstadoRiesgo e =new Alerta();
            zona.cambiarEstado(e);
            e.entrar(zona);
        }
    }

    @Override
    public void entrar(Zona zona) {

        System.out.println(
            "WHATSAPP URGENTE: Aviso al equipo de respuesta."
        );
    }

    @Override
    public String nombre() {

        return "Emergencia";
    }
}