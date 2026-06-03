package com.example;

import java.util.List;

public class WeatherDataDecorator implements WeatherData {
    protected WeatherData weatherData;

    public WeatherDataDecorator(WeatherData weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public double getTemperatura() {
        return weatherData.getTemperatura();
    }

    @Override
    public double getPresion() {
        return weatherData.getPresion();
    }

    @Override

    public double getRadiacionSolar() {
        return weatherData.getRadiacionSolar();
    }

    @Override
    public List<Double> getTemperaturas(){
        return weatherData.getTemperaturas();
    }

    @Override
    public String displayData() {
        return weatherData.displayData();
    }
}
