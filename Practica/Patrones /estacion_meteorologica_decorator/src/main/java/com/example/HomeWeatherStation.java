package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWeatherStation implements WeatherData {
    private double temperatura = 86.0;
    private double presion = 1008.0;
    private double radiacionSolar = 200.0;

    private List<Double> temperaturasHistoricas;

    public HomeWeatherStation() {
        this.temperaturasHistoricas = new ArrayList<>(Arrays.asList(80.6, 86.0, 89.6, 86.0));
    }

    @Override
    public double getTemperatura() {
        return temperatura;
    }

    @Override
    public double getPresion() {
        return presion;
    }

    @Override
    public double getRadiacionSolar() {
        return radiacionSolar;
    }

    @Override
    public List<Double> getTemperaturas() {
        return new ArrayList<>(temperaturasHistoricas);
    }

    @Override
    public String displayData() {
        return "Temperatura F: " + String.format("%.0f", this.getTemperatura()) +
                "; Presión atmosf: " + String.format("%.0f", this.getPresion()) +
                "; Radiación solar: " + String.format("%.0f", this.getRadiacionSolar());
    }

    // Setters
    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public void setPresion(double presion) {
        this.presion = presion;
    }

    public void setRadiacionSolar(double radiacionSolar) {
        this.radiacionSolar = radiacionSolar;
    }

    public void setTemperaturasHistoricas(List<Double> temperaturas){
        this.temperaturasHistoricas=new ArrayList<>(temperaturas);
    }

}
