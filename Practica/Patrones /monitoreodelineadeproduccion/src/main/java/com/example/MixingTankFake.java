package com.example;

// MixingTankFake.java
public class MixingTankFake extends MixingTank {
    private int heatPowerLevel;
    private int mixerPowerLevel;
    private double volume;
    private double temperature;
    private boolean purged;
    private long elapsedTime; // Para simular tiempo

    public MixingTankFake(double initialVolume, double initialTemp) {
        this.volume = initialVolume;
        this.temperature = initialTemp;
        this.heatPowerLevel = 0;
        this.mixerPowerLevel = 0;
        this.purged = false;
        this.elapsedTime = 0;
    }

    @Override
    public boolean heatPower(int percentage) {
        if (percentage < 0 || percentage > 100)
            return false;
        this.heatPowerLevel = percentage;
        return true;
    }

    @Override
    public boolean mixerPower(int percentage) {
        if (percentage < 0 || percentage > 100)
            return false;
        this.mixerPowerLevel = percentage;
        return true;
    }

    @Override
    public boolean purge() {
        this.purged = true;
        return true;
    }

    @Override
    public double upTo() {
        // Simular que después de purge y tiempo, el volumen disminuye
        if (purged && elapsedTime >= 4000) {
            return 0;
        }
        return volume;
    }

    @Override
    public double temperature() {
        // Calcular temperatura según potencia y tiempo transcurrido
        double tempIncreasePerSecond = getTempIncreaseRate();
        double secondsElapsed = elapsedTime / 1000.0;
        return temperature + (tempIncreasePerSecond * secondsElapsed);
    }

    private double getTempIncreaseRate() {
        if (heatPowerLevel >= 100)
            return 5.0;
        if (heatPowerLevel >= 75)
            return 4.0;
        if (heatPowerLevel >= 50)
            return 2.0;
        if (heatPowerLevel >= 25)
            return 1.0;
        return 0.0;
    }

    // Método para simular el paso del tiempo
    public void simulateTimePassing(long milliseconds) {
        this.elapsedTime += milliseconds;

        // Actualizar temperatura basada en el tiempo
        if (heatPowerLevel > 0) {
            double tempIncrease = getTempIncreaseRate() * (milliseconds / 1000.0);
            this.temperature += tempIncrease;
        }

        // Si está purgando y pasaron 4 segundos, vaciar tanque
        if (purged && elapsedTime >= 4000) {
            this.volume = 0;
        }
    }

    // Reset para nuevos tests
    public void reset() {
        this.elapsedTime = 0;
        this.purged = false;
        this.heatPowerLevel = 0;
        this.mixerPowerLevel = 0;
    }
}
