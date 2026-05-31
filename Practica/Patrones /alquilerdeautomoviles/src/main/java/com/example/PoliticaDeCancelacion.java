package com.example;

import java.time.LocalDate;

public interface PoliticaDeCancelacion {

    double calcularReembolso(Reserva reserva, LocalDate fechaDeCancelacion);
}
