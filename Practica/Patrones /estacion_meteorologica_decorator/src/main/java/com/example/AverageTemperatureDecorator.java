package com.example;

public class AverageTemperatureDecorator extends WeatherDataDecorator {
    private boolean enCelsius;

    public AverageTemperatureDecorator(WeatherData weatherData) {
        this(weatherData, false);
    }

    public AverageTemperatureDecorator(WeatherData weatherData, boolean enCelsius) {
        super(weatherData);
        this.enCelsius = enCelsius;
    }

    private double calcularPromedio() {
        return weatherData.getTemperaturas().stream()
                .mapToDouble(temp -> enCelsius ? (temp - 32) / 1.8 : temp)
                .average()
                .orElse(0.0);
    }

    @Override
    public String displayData() {
        String datosBase = weatherData.displayData();
        double promedio = calcularPromedio();

        return datosBase + "; Promedio: " + String.format("%.0f", promedio) + ";";
    }
}
