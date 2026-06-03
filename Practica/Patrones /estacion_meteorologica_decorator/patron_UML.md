```table
| Elemento              | Rol                                | Clase                          |
|-----------------------|------------------------------------|--------------------------------|
| Component             | Interfaz base                      | `WeatherData`                  |
| Concrete Component    | Objeto original                    | `HomeWeatherStation`           |
| Decorator             | Base para decoradores              | `WeatherDataDecorator`         |
| Concrete Decorator    | Funcionalidad específica           | `TemperatureCelsiusDecorator`  |
| Concrete Decorator    | Funcionalidad específica           | `AverageTemperatureDecorator`  |
| Concrete Decorator    | Funcionalidad específica           | `MinMaxTemperatureDecorator`   |
```
```mermaid
classDiagram
    class WeatherData {
        <<interface>>
        +getTemperatura() double
        +getPresion() double
        +getRadiacionSolar() double
        +getTemperaturas() List~Double~
        +displayData() String
    }
    
    class HomeWeatherStation {
        +getTemperatura() double
        +getPresion() double
        +getRadiacionSolar() double
        +getTemperaturas() List~Double~
        +displayData() String
    }
    
    class WeatherDataDecorator {
        #weatherData: WeatherData
        +getTemperatura() double
        +getPresion() double
        +getRadiacionSolar() double
        +getTemperaturas() List~Double~
        +displayData() String
    }
    
    class TemperatureCelsiusDecorator {
        +getTemperatura() double
        +displayData() String
    }
    
    class AverageTemperatureDecorator {
        +displayData() String
    }
    
    class MinMaxTemperatureDecorator {
        +displayData() String
    }
    
    WeatherData <|.. HomeWeatherStation : implements
    WeatherData <|.. WeatherDataDecorator : implements
    WeatherDataDecorator o-- WeatherData : composición
    WeatherDataDecorator <|-- TemperatureCelsiusDecorator
    WeatherDataDecorator <|-- AverageTemperatureDecorator
    WeatherDataDecorator <|-- MinMaxTemperatureDecorator
    
    note for WeatherDataDecorator "Decorator Base:\nMantiene referencia\nal objeto decorado"
    note for TemperatureCelsiusDecorator "Convierte F a C:\nºC = (ºF-32) ÷ 1.8"
```