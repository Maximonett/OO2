package com.example;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class EstacionMeteorologicaTest {

    @Test
    public void testEjemplo5_TemperaturaC_Promedio_MinMax() {
        // Crear la estación base
        HomeWeatherStation estacion = new HomeWeatherStation();

        // Configurar los valores del ejemplo
        estacion.setTemperatura(86.0); // 30°C
        estacion.setPresion(1008.0);
        estacion.setRadiacionSolar(200.0);

        // Temperaturas históricas en Fahrenheit:
        // 80.6°F = 27°C, 86°F = 30°C, 89.6°F = 32°C, 86°F = 30°C
        estacion.setTemperaturasHistoricas(
                Arrays.asList(80.6, 86.0, 89.6, 86.0));

        // Aplicar decoradores en el orden necesario:
        // 1. Primero convertir a Celsius
        WeatherData conCelsius = new TemperatureCelsiusDecorator(estacion);

        // 2. Agregar promedio (en Celsius)
        WeatherData conPromedio = new AverageTemperatureDecorator(conCelsius, true);

        // 3. Agregar mínimo y máximo (en Celsius)
        WeatherData conMinMax = new MinMaxTemperatureDecorator(conPromedio, true);

        // Obtener el resultado
        String resultado = conMinMax.displayData();

        System.out.println("Resultado: " + resultado);

        // Verificar que contenga todos los elementos esperados
        assertTrue(resultado.contains("Temperatura C: 30"));
        assertTrue(resultado.contains("Presión atmosf: 1008"));
        assertTrue(resultado.contains("Radiación solar: 200"));
        assertTrue(resultado.contains("Promedio: 30"));
        assertTrue(resultado.contains("Mínimo: 27"));
        assertTrue(resultado.contains("Máximo: 32"));

        // Verificar el formato completo (puede variar el orden)
        assertEquals(
                "Temperatura C: 30; Presión atmosf: 1008; Radiación solar: 200; " +
                        "Promedio: 30; Mínimo: 27 Máximo: 32;",
                resultado);
    }

    @Test
    public void testEjemplo1_SoloDatosBasicosEnFahrenheit() {
        HomeWeatherStation estacion = new HomeWeatherStation();
        estacion.setTemperatura(86.0);
        estacion.setPresion(1008.0);
        estacion.setRadiacionSolar(200.0);

        String resultado = estacion.displayData();

        assertTrue(resultado.contains("Temperatura F: 86"));
        assertTrue(resultado.contains("Presión atmosf: 1008"));
        assertTrue(resultado.contains("Radiación solar: 200"));
    }

    @Test
    public void testEjemplo2_TemperaturaEnCelsius() {
        HomeWeatherStation estacion = new HomeWeatherStation();
        estacion.setTemperatura(86.0); // 30°C
        estacion.setPresion(1008.0);
        estacion.setRadiacionSolar(200.0);

        WeatherData conCelsius = new TemperatureCelsiusDecorator(estacion);
        String resultado = conCelsius.displayData();

        assertTrue(resultado.contains("Temperatura C: 30"));
        assertFalse(resultado.contains("Temperatura F"));
    }

    @Test
    public void testCombinacionFlexible_DiferentesOrdenes() {
        HomeWeatherStation estacion = new HomeWeatherStation();
        estacion.setTemperatura(86.0);
        estacion.setPresion(1008.0);
        estacion.setRadiacionSolar(200.0);
        estacion.setTemperaturasHistoricas(Arrays.asList(80.6, 86.0, 89.6));

        // Orden 1: Celsius -> MinMax -> Promedio
        WeatherData config1 = new TemperatureCelsiusDecorator(estacion);
        config1 = new MinMaxTemperatureDecorator(config1, true);
        config1 = new AverageTemperatureDecorator(config1, true);

        // Orden 2: MinMax -> Celsius -> Promedio
        WeatherData config2 = new MinMaxTemperatureDecorator(estacion, false);
        config2 = new TemperatureCelsiusDecorator(config2);
        config2 = new AverageTemperatureDecorator(config2, true);

        // Ambos deberían funcionar (aunque el formato puede variar ligeramente)
        assertNotNull(config1.displayData());
        assertNotNull(config2.displayData());

        assertTrue(config1.displayData().contains("Temperatura C"));
        assertTrue(config1.displayData().contains("Promedio"));
        assertTrue(config1.displayData().contains("Mínimo"));
        assertTrue(config1.displayData().contains("Máximo"));
    }
}
