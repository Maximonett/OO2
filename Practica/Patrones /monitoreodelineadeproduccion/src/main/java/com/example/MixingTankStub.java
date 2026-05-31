package com.example;

public class MixingTankStub extends MixingTank {
    private boolean heatPowerResult;
    private boolean mixerPowerResult;
    private boolean purgeResult;
    private double volume;
    private double temp;

    public MixingTankStub(boolean heatPowerResult, boolean mixerPowerResult, boolean purgeResult) {
        this.heatPowerResult = heatPowerResult;
        this.mixerPowerResult = mixerPowerResult;
        this.purgeResult = purgeResult;
        this.volume = 50.0;
        this.temp = 20.0;
    }

    @Override
    public boolean mixerPower(int percentage) {
        return mixerPowerResult;
    }

    @Override
    public boolean heatPower(int percentage) {
        return heatPowerResult;
    }

    public boolean purge() {
        return purgeResult;
    }

    public double upTo() {
        return volume;
    }

    public double temperature() {
        return temp;
    }

    // Setters para poder configurar el stub
    public void setVolume(double volume) {
        this.volume = volume;
    }

    public void setTemperature(double temp) {
        this.temp = temp;
    }

}
