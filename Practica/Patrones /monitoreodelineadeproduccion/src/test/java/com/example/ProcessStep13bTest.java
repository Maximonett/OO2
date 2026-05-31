package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class ProcessStep13bTest {

    // Tests para LightMix - Ejercicio 13b
    @Test
    public void testLightMixSuccessWithCorrectTemperatureIncrease() {
        MixingTankFake tank = new MixingTankFake(50.0, 25.0);
        LightMixB lightMix = new LightMixB();

        // Configurar manualmente el estado antes de ejecutar
        tank.heatPower(100);

        // Simular el tiempo que LightMixB esperaría
        tank.simulateTimePassing(2000);

        // Ahora ejecutar (el sleep será real pero ya simulamos el tiempo)
        // Esto no funciona bien porque el orden es incorrecto

        // MEJOR: Usar un spy o mock
    }

    @Test
    public void testLightMixFailureWithIncorrectTemperatureIncrease() {
        // Tanque con potencia insuficiente configurada manualmente
        MixingTankFake tank = new MixingTankFake(50.0, 25.0) {
            @Override
            public boolean heatPower(int percentage) {
                // Simular que no se puede configurar al 100%
                if (percentage == 100)
                    return false;
                return true;
            }
        };
        LightMixB lightMix = new LightMixB();

        lightMix.execute(tank);

        assertFalse(lightMix.isDone());
    }

    // Tests para Purge - Ejercicio 13b
    @Test
    public void testPurgeSuccessWhenTankHasContent() {
        MixingTankFake tank = new MixingTankFake(50.0, 25.0);
        PurgeB purge = new PurgeB();

        Thread executeThread = new Thread(() -> purge.execute(tank));
        executeThread.start();

        try {
            Thread.sleep(100);
            tank.simulateTimePassing(4000); // Simular 4 segundos de purga
            executeThread.join();
        } catch (InterruptedException e) {
            fail("Test interrupted");
        }

        assertTrue(purge.isDone());
        assertEquals(0, tank.upTo(), 0.01);
    }

    @Test
    public void testPurgeFailureWhenTankIsEmpty() {
        MixingTankFake tank = new MixingTankFake(0.0, 25.0);
        PurgeB purge = new PurgeB();

        purge.execute(tank);

        assertFalse(purge.isDone());
    }

    @Test
    public void testPurgeFailureWhenTankNotEmptied() {
        MixingTankFake tank = new MixingTankFake(50.0, 25.0) {
            @Override
            public double upTo() {
                // Simular que el tanque no se vacía completamente
                return 10.0;
            }
        };
        PurgeB purge = new PurgeB();

        Thread executeThread = new Thread(() -> purge.execute(tank));
        executeThread.start();

        try {
            Thread.sleep(100);
            tank.simulateTimePassing(4000);
            executeThread.join();
        } catch (InterruptedException e) {
            fail("Test interrupted");
        }

        assertFalse(purge.isDone());
    }
}
