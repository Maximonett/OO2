package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class ProcessStepTest {

    // Tests para LightMix - Ejercicio 13
    @Test
    public void testLightMixSuccess() {
        MixingTankStub tank = new MixingTankStub(true, true, true);
        LightMix lightMix = new LightMix();

        lightMix.execute(tank);

        assertTrue(lightMix.isDone());
    }

    @Test
    public void testLightMixFailureWhenHeatPowerFails() {
        MixingTankStub tank = new MixingTankStub(false, true, true);
        LightMix lightMix = new LightMix();

        lightMix.execute(tank);

        assertFalse(lightMix.isDone());
    }

    @Test
    public void testLightMixFailureWhenMixerPowerFails() {
        MixingTankStub tank = new MixingTankStub(true, false, true);
        LightMix lightMix = new LightMix();

        lightMix.execute(tank);

        assertFalse(lightMix.isDone());
    }

    // Tests para Purge - Ejercicio 13
    @Test
    public void testPurgeSuccess() {
        MixingTankStub tank = new MixingTankStub(true, true, true);
        Purge purge = new Purge();

        purge.execute(tank);

        assertTrue(purge.isDone());
    }

    @Test
    public void testPurgeFailureWhenHeatPowerFails() {
        MixingTankStub tank = new MixingTankStub(false, true, true);
        Purge purge = new Purge();

        purge.execute(tank);

        assertFalse(purge.isDone());
    }

    @Test
    public void testPurgeFailureWhenPurgeFails() {
        MixingTankStub tank = new MixingTankStub(true, true, false);
        Purge purge = new Purge();

        purge.execute(tank);

        assertFalse(purge.isDone());
    }
}