package com.example;

/**
 * Clase Tierra.
 * Representa un terreno atómico (Hoja) uniforme de Tierra (0% agua).
 */
public class Tierra extends Hoja {

    public Tierra() {
        // Llama al constructor de Hoja (super) fijando el valor conceptual
        // de Tierra: 0.0 (0%).
        super(0.0);
    }

    // --- Métodos de Gancho para Double Dispatch ---
    // (Implementación requerida por la interfaz Topografia)

    @Override
    public boolean esIgualAPantano(Pantano pantano) {
        // Una Hoja genérica o de Tierra nunca es igual a un Pantano
        return false;
    }

    // esIgualaMixta() ya está implementado en la clase padre Hoja (devolviendo false)
    // por lo que no es estrictamente necesario sobrescribirlo aquí.
}
