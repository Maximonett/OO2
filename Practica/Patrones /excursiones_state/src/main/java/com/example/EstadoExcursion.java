package com.example;

public interface EstadoExcursion {
    void inscribir(Excursion excursion, Usuario usuario);

    String obtenerInformacion(Excursion excursion);
}
