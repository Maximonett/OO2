package com.example;

public class Precaucion implements EstadoRiesgo {

    @Override
    public void actualizar(Zona zona, double co2) {

        if (co2 >= 1200) {
            EstadoRiesgo e =new Emergencia();
            zona.cambiarEstado(e);
            e.entrar(zona);

        } else if (co2 >= 800) {
            EstadoRiesgo  e=new Alerta();
            zona.cambiarEstado(e);
            e.entrar(zona);

        } else if (co2 < 500) {
            EstadoRiesgo e=new Normal()
            zona.cambiarEstado(new Normal());
            e.entrar(zona);
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