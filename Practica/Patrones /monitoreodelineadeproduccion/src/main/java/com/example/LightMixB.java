package com.example;

public class LightMixB extends ProcessStep {
    @Override
    protected boolean basicExecute(MixingTank tank) {
        try {
            double temp = tank.temperature();
            tank.heatPower(100);
            Thread.sleep(2000); // 2 segundos

            if (tank.temperature() - temp == 10) {
                tank.mixerPower(5);
                return true;
            }
            return false;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
