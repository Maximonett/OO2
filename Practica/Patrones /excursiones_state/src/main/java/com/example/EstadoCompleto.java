package com.example;

public class EstadoCompleto implements EstadoExcursion {

    @Override
    public void inscribir(Excursion excursion, Usuario usuario) {
        excursion.agregarAListaEspera(usuario);
        System.out.println("Cupo lleno. Usuario agregado a LISTA DE ESPERA: " + usuario.getEmail());
        // No hay transición de salida, se mantiene completa.
    }

    @Override
    public String obtenerInformacion(Excursion excursion) {
        return "Excursión: " + excursion.getNombre() +
                " | Estado: COMPLETA (Cupo Máximo Alcanzado)";
    }
}
