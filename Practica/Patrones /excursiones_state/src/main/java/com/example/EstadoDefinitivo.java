package com.example;

public class EstadoDefinitivo implements EstadoExcursion {
    @Override
    public void inscribir(Excursion excursion, Usuario usuario) {
        excursion.agregarInscripto(usuario);
        System.out.println("Inscripcion Definitiva para " + usuario.getEmail());

        if (excursion.getCantidadInscriptos() >= excursion.getCupoMaximo()) {
            excursion.cambiarEstado(new EstadoCompleto());
        }
    }

    @Override
    public String obtenerInformacion(Excursion excursion) {
        int faltantes = excursion.getCupoMaximo() - excursion.getCantidadInscriptos();

        StringBuilder mails = new StringBuilder();
        for (Usuario u : excursion.getInscriptos()) {
            mails.append(u.getEmail()).append(", ");
        }
        return "Excursión: " + excursion.getNombre() +
                " | Estado: Definitiva | Inscritos: [" + mails.toString() +
                "] | Cupos disponibles: " + faltantes;
    }
}
