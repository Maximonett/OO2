package com.example;

public class MinMaxTemperatureDecorator extends WeatherDataDecorator {
    private boolean enCelsius;

    public MinMaxTemperatureDecorator(WeatherData weatherData) {
        this(weatherData, false);
    }

    public MinMaxTemperatureDecorator(WeatherData weatherData, boolean enCelsius) {
        super(weatherData);
        this.enCelsius = enCelsius;
    }

    private double[] calcularMinMax() {
        var temperaturas = weatherData.getTemperaturas();

        double min = temperaturas.stream()
                .mapToDouble(temp -> enCelsius ? (temp - 32) / 1.8 : temp)
                .min()
                .orElse(0.0);

        double max = temperaturas.stream()
                .mapToDouble(temp -> enCelsius ? (temp - 32) / 1.8 : temp)
                .max()
                .orElse(0.0);

        return new double[] { min, max };
    }

    @Override
    public String displayData() {
        String datosBase = weatherData.displayData();
        double[] minMax = calcularMinMax();

        return datosBase + " Mínimo: " + String.format("%.0f", minMax[0]) +
                " Máximo: " + String.format("%.0f", minMax[1]) + ";";
    }
}
