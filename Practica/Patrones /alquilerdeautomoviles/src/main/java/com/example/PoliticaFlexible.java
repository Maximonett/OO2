package com.example;

import java.time.LocalDate;

public class PoliticaFlexible implements PoliticaDeCancelacion {

    public double calcularReembolso(Reserva reserva, LocalDate fechaDeCancelacion) {
        return reserva.montoAPagar();
    }

}
