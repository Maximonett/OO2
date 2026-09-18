package com.example;

public class Main {

    public static void main(String[] args) {

        Sensor sensor1 = new Sensor("Sensor 1", 450);
        Sensor sensor2 = new Sensor("Sensor 2", 700);

        Zona zona1 = new Zona("Zona Centro");

        zona1.agregar(sensor1);
        zona1.agregar(sensor2);

        PlantECOO planta = new PlantECOO(zona1);

        // Usa el mecanismo por defecto
        zona1.activarMitigacion();

        // Se cambia la estrategia
        zona1.definirMecanismo(new BarrerasVegetales());

        zona1.activarMitigacion();

        // Se vuelve a cambiar
        zona1.definirMecanismo(new InspeccionTecnica());

        zona1.activarMitigacion();
    }
}