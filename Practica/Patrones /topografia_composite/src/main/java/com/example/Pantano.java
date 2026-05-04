package com.example;

public class Pantano extends Hoja {

    /**
     * Constructor. 
     * Un Pantano siempre tiene una proporción fija de 0.7 de agua.
     * Reutiliza la variable de instancia 'proporcionAgua' heredada de Hoja
     * pasándole el valor al constructor del padre.
     */
    public Pantano() {
        super(0.7);
    }

    // --- Lógica de Igualdad Estructural (Double Dispatch) ---

    @Override
    public boolean equals(Object topo) {
        // PRIMER DESPACHO:
        // Verificamos si es una Topografia para poder usar Double Dispatch
        if (topo instanceof Topografia) {
            // Le invertimos la pregunta al objeto recibido.
            // "Oye 'topo', ¿tú eres igual a mí, que soy un Pantano (this)?"
            return ((Topografia)topo).esIgualAPantano(this);
        }
        return false;
    }

    @Override
    public boolean esIgualAPantano(Pantano pantano) {
        // SEGUNDO DESPACHO:
        // Si llegamos aca, significa que estamos comparando un Pantano 
        // contra otro Pantano. 
        // Como todos los pantanos son estructuralmente iguales (tienen 0.7),
        // devolvemos true directamente.
        return true;
    }

    @Override
    public boolean esIgualAMixta(Mixta mixta) {
        // Un Pantano es un terreno atómico. 
        // Conceptualmente, no es igual a un terreno compuesto (Mixta).
        return false;
    }
}
