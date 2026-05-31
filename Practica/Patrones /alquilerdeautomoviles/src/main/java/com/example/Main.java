
package com.example;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // 1. Fecha de reserva (hoy)
        LocalDate fechaReserva = LocalDate.now();

        // 2. Cancelación (1 día antes)
        LocalDate fechaCancelacion = fechaReserva.minusDays(1);

        // 3. Auto con política flexible
        AutoEnAlquiler auto = new AutoEnAlquiler(100, 5, "Toyota", new PoliticaFlexible());

        // 4. Reserva (10 días)
        Reserva miReserva = new Reserva(10, fechaReserva, auto);

        System.out.println("--- Escenario 1: Política Flexible ---");
        double reembolsoFlexible = miReserva.montoAReembolsar(fechaCancelacion);
        System.out.println("Monto a pagar total: " + miReserva.montoAPagar());
        System.out.println("Reembolso obtenido: " + reembolsoFlexible);

        // 5. Cambio de política en runtime
        System.out.println("\n--- Escenario 2: Política Moderada ---");
        auto.setPolitica(new PoliticaModerada());

        double reembolsoModerado = miReserva.montoAReembolsar(fechaCancelacion);
        System.out.println("Reembolso (1 día antes): " + reembolsoModerado);

        // Cancelación 3 días antes
        LocalDate fechaCancelacionLejana = fechaReserva.minusDays(3);
        double reembolsoModeradoLejano = miReserva.montoAReembolsar(fechaCancelacionLejana);

        System.out.println("Reembolso (3 días antes): " + reembolsoModeradoLejano);
    }
}