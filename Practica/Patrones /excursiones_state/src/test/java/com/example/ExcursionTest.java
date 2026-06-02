package com.example;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test; // ← ¡No olvidar este import!

public class ExcursionTest {

    @Test
    public void testFlujoCompletoExcursion() {
        // 1. Instanciar excursión con TODOS los parámetros requeridos
        Excursion kayak = new Excursion(
                "Dos días en kayak bajando el Paraná", // nombre
                LocalDate.of(2024, 6, 1), // fechaInicio
                LocalDate.of(2024, 6, 2), // fechaFin
                "Puerto Colón", // puntoEncuentro
                5000.0, // costo
                1, // cupoMinimo
                2 // cupoMaximo
        );

        Usuario u1 = new Usuario("Juan", "Perez", "juan@mail.com");
        Usuario u2 = new Usuario("Ana", "Gomez", "ana@mail.com");
        Usuario u3 = new Usuario("Luis", "Torres", "luis@mail.com");

        // --- Estado Inicial (0 inscriptos) -> Provisoria ---
        System.out.println("--- Info Inicial ---");
        String info1 = kayak.obtenerInformacion();
        System.out.println(info1);
        assertTrue(info1.contains("Provisoria")); // ← Ojo con el nombre del estado
        assertTrue(info1.contains("Faltan: 1"));

        // 2. Inscribir Usuario 1 -> Debería pasar a Definitivo (Min=1)
        System.out.println("\n--- Inscribiendo a Juan ---");
        kayak.inscribir(u1);

        String info2 = kayak.obtenerInformacion();
        System.out.println(info2);
        assertTrue(info2.contains("Definitiva")); // ← Ojo con el nombre del estado
        assertTrue(info2.contains("juan@mail.com"));
        assertTrue(info2.contains("Cupos disponibles: 1"));

        // 3. Inscribir Usuario 2 -> Debería pasar a Completo (Max=2)
        System.out.println("\n--- Inscribiendo a Ana ---");
        kayak.inscribir(u2);

        String info3 = kayak.obtenerInformacion();
        System.out.println(info3);
        assertTrue(info3.contains("COMPLETO")); // ← Ojo con el nombre del estado
        assertFalse(info3.contains("Faltan"));

        // 4. Inscribir Usuario 3 -> Lista de espera, estado se mantiene Completo
        System.out.println("\n--- Inscribiendo a Luis (Extra) ---");
        kayak.inscribir(u3);

        String info4 = kayak.obtenerInformacion();
        System.out.println(info4);
        assertTrue(info4.contains("COMPLETO"));
    }
}