package com.example;

public class PurgeB extends ProcessStep {
    @Override
    protected boolean basicExecute(MixingTank tank) {
        try {
            if (tank.upTo() == 0) {
                return false;
            } else {
                tank.heatPower(0);
                tank.mixerPower(0);
                tank.purge();
                Thread.sleep(4000); // 4 segundos

                if (tank.upTo() != 0) {
                    return false;
                }
                return true;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }
    }
}
