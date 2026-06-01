package com.example;

public interface Estado {
    void inscribir(Excursion excursion, Usuario usuario);

    String obtenerInformacion(Excursion excursion);
}
