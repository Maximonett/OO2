package com.example;

public class Precaucion implements EstadoRiesgo {

    @Override
    public void actualizar(Zona zona, double co2) {

        if (co2 >= 1200) {

            zona.cambiarEstado(new Emergencia());

        } else if (co2 >= 800) {

            zona.cambiarEstado(new Alerta());

        } else if (co2 < 500) {

            zona.cambiarEstado(new Normal());
        }
    }

    @Override
    public void entrar(Zona zona) {

        System.out.println(
            "LOG: La zona ingresó en PRECAUCIÓN."
        );

        System.out.println(
            "EMAIL: Aviso a responsables ambientales."
        );
    }

    @Override
    public String nombre() {

        return "Precaucion";
    }
}