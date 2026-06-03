package com.example;

public class TemperatureCelsiusDecorator extends WeatherDataDecorator {

    public TemperatureCelsiusDecorator(WeatherData weatherData) {
        super(weatherData);
    }

    public double convertirACelsius(double temperatura) {
        return (temperatura - 32) / 1.8;
    }

    @Override
    public double getTemperatura() {
        double fahrenheit = weatherData.getTemperatura();
        return convertirACelsius(fahrenheit);
    }

    @Override
    public String displayData() {
        String base = weatherData.displayData();
        String celsiusLabel = "Temperatura C: " + String.format("%.0f", this.getTemperatura());
        return base.replaceFirst("Temperatura F: [^;]+", celsiusLabel);
    }

}
