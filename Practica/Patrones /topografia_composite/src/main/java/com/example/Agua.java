package com.example;

/**
 * Clase Agua.
 * Representa un terreno atómico (Hoja) uniforme de Agua (100% agua).
 */
public class Agua extends Hoja {

    public Agua() {
        // Llama al constructor de Hoja (super) fijando el valor conceptual
        // de Agua: 1.0 (100%).
        super(1.0);
    }

    // --- Métodos de Gancho para Double Dispatch ---
    // (Implementación requerida por la interfaz Topografia)

    @Override
    public boolean esIgualAPantano(Pantano pantano) {
        // Una Hoja genérica o de Agua nunca es igual a un Pantano
        return false;
    }

    // esIgualaMixta() ya está implementado en la clase padre Hoja (devolviendo false)
    // por lo que no es estrictamente necesario sobrescribirlo aquí.
}