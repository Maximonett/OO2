package com.example;

public class EstadoProvisorio implements EstadoExcursion {
    @Override
    public void inscribir(Excursion excursion, Usuario usuario) {
        excursion.agregarInscripto(usuario);
        System.out.println("Inscripcion Provisoria para: " + usuario.getEmail());

        // Verificar transicicon
        if (excursion.getCantidadInscriptos() >= excursion.getCupoMinimo()) {
            excursion.cambiarEstado(new EstadoDefinitivo());
        }
    }

    @Override
    public String obtenerInformacion(Excursion excursion) {
        int faltantes = excursion.getCupoMinimo() - excursion.getCantidadInscriptos();
        return "Excursion: " + excursion.getNombre() +
                "| Estado: Provisoria |Faltan: " + faltantes + " para confirmar.";
    }
}
