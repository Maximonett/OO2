
```mermaid
classDiagram
    %% ==================== CLASES PRINCIPALES ====================
    
    class MixingTank {
        <<abstract>>
        +heatPower(percentage: Integer) Boolean
        +mixerPower(percentage: Integer) Boolean
        +purge() Boolean
        +upTo() Real
        +temperature() Real
    }
    
    class I2CDriver {
        -SCL: Integer
        -SDL: Integer
        +sendStartSeq() Boolean
        +sendAddress(address: String) Boolean
        +sendCommand(command: String) Boolean
        +sendStopSeq() Boolean
    }
    
    class ProcessStep {
        <<abstract>>
        -result: Boolean
        +execute(tank: MixingTank)
        #basicExecute(tank: MixingTank) Boolean
        +isDone() Boolean
        -setSuccess()
        -setFailure()
    }
    
    class LightMix {
        #basicExecute(tank: MixingTank) Boolean
    }
    
    class Purge {
        #basicExecute(tank: MixingTank) Boolean
    }
    
    %% ==================== TEST DOBLES EJERCICIO 13 ====================
    
    class MixingTankStub {
        -heatPowerResult: Boolean
        -mixerPowerResult: Boolean
        -purgeResult: Boolean
        -volume: Double
        -temp: Double
        +heatPower(percentage: Integer) Boolean
        +mixerPower(percentage: Integer) Boolean
        +purge() Boolean
        +upTo() Real
        +temperature() Real
        +setVolume(volume: Double)
        +setTemperature(temp: Double)
    }
    
    %% ==================== TEST DOBLES EJERCICIO 13b ====================
    
    class MixingTankFake {
        -heatPowerLevel: Integer
        -mixerPowerLevel: Integer
        -volume: Double
        -temperature: Double
        -purged: Boolean
        -elapsedTime: Long
        +heatPower(percentage: Integer) Boolean
        +mixerPower(percentage: Integer) Boolean
        +purge() Boolean
        +upTo() Real
        +temperature() Real
        +simulateTimePassing(milliseconds: Long)
        +reset()
        -getTempIncreaseRate() Double
    }
    
    %% ==================== CLASES DE TEST ====================
    
    class ProcessStepTest {
        +testLightMixSuccess()
        +testLightMixFailureWhenHeatPowerFails()
        +testLightMixFailureWhenMixerPowerFails()
        +testPurgeSuccess()
        +testPurgeFailureWhenHeatPowerFails()
        +testPurgeFailureWhenPurgeFails()
    }
    
    class ProcessStep13bTest {
        +testLightMixSuccessWithCorrectTemperatureIncrease()
        +testLightMixFailureWithIncorrectTemperatureIncrease()
        +testPurgeSuccessWhenTankHasContent()
        +testPurgeFailureWhenTankIsEmpty()
        +testPurgeFailureWhenTankNotEmptied()
    }
    
    %% ==================== RELACIONES ====================
    
    %% MixingTank tiene una composición con I2CDriver
    MixingTank *-- I2CDriver : composición
    
    %% ProcessStep depende de MixingTank
    ProcessStep ..> MixingTank : dependencia
    
    %% Herencia
    LightMix --|> ProcessStep : herencia
    Purge --|> ProcessStep : herencia
    
    %% Test Doubles
    MixingTankStub --|> MixingTank : herencia
    MixingTankFake --|> MixingTank : herencia
    
    %% Tests dependen de las clases
    ProcessStepTest ..> LightMix : test
    ProcessStepTest ..> Purge : test
    ProcessStepTest ..> MixingTankStub : usa
    ProcessStep13bTest ..> LightMix : test
    ProcessStep13bTest ..> Purge : test
    ProcessStep13bTest ..> MixingTankFake : usa
    
    %% Notas explicativas
    note for ProcessStep "Template Method Pattern:\nexecute() define el algoritmo\nbasicExecute() es implementado\npor las subclases"
    
    note for MixingTankFake "Fake: Implementación funcional\nsimplificada que simula:\n- Cálculo de temperatura\n- Simulación de tiempo\n- Cambios de estado"
    
    note for MixingTankStub "Stub: Respuestas predefinidas\nsin lógica de negocio,\nsolo retorna valores fijos"
    ```
