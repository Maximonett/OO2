package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonajeTest {

    // 1. Los tests de los Builders no cambian NADA.
    // No dependen del Factory, prueban la construcción paso a paso.
    @Test
    public void testCreacionGuerrero() {
        PersonajeBuilder builder = new GuerreroBuilder("Aragorn");
        builder.construirArmadura();
        builder.construirArma();
        builder.construirHabilidades();
        Personaje guerrero = builder.getPersonaje();

        assertEquals("Aragorn", guerrero.getNombre());
        assertTrue(guerrero.getArmadura() instanceof ArmaduraDeAcero);
    }

    // 2. Los tests de lógica de juego (peleas, vida) tampoco cambian.
    @Test
    public void testEnfrentamientoGuerreroVsMago() {
        Personaje guerrero = new GuerreroBuilder("Aragorn")
                .construirArmadura().construirArma().construirHabilidades()
                .getPersonaje();

        Personaje mago = new MagoBuilder("Gandalf")
                .construirArmadura().construirArma().construirHabilidades()
                .getPersonaje();

        guerrero.recibirAtaque(mago);
        assertEquals(99, guerrero.getPuntosDeVida());
    }

    // 3. EL ÚNICO TEST QUE MIRA EL FACTORY:
    @Test
    public void testFactoryCreaPersonajes() {
        PersonajeFactory factory = new PersonajeFactory();

        // Estos funcionan automáticamente si están en el static {} del Factory
        Personaje guerrero = factory.crearPersonaje("GUERRERO", "Aragorn");
        assertTrue(guerrero.getArma() instanceof Espada);

        Personaje mago = factory.crearPersonaje("MAGO", "Gandalf");
        assertTrue(mago.getArma() instanceof Baston);

        // --- SI THOOR FUE REGISTRADO DINÁMICAMENTE ---
        // Si en tu diseño Thoor se agrega "en caliente", el test debe registrarlo
        // primero:
        PersonajeFactory.registrar("THOOR", nombre -> new ThoorBuilder(nombre)
                .construirArmadura()
                .construirArma()
                .construirHabilidades()
                .getPersonaje());

        Personaje thoor = factory.crearPersonaje("THOOR", "Thor");
        assertTrue(thoor.getArma() instanceof Martillo);
        assertTrue(thoor.getArmadura() instanceof ArmaduraDeHierro);
    }

    // 4. Test para verificar que el Map tira error si no existe el tipo
    @Test
    public void testFactoryLanzaErrorSiTipoNoExiste() {
        PersonajeFactory factory = new PersonajeFactory();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.crearPersonaje("NINJA", "Shadow");
        });

        assertTrue(exception.getMessage().contains("desconocido"));
    }
}
