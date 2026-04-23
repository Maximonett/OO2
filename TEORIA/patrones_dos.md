# Nuevos patrones Strategy State

### Ejemplo 1: App de compresion de archivos...

La problematica es resolver diferentes archivos de compresion en una clase que solo
comprime y descomprime RAR, ZIP, GZ....

* Se crea la clase COMPRESION
* Se crea una CLASE INTERMEDIA STRATEGY en la cual se hace la estrategia de compresion (ZIP,RAR,etc)...
* Y se crean SUB CLASES RAR, ZIP...etc.

### Ejemplo 2: Delivery de comida

* Mal olor! eso es un Objeto... y se ve que a los metodos de pagos es un String y no un objeto.
* ¿Como agregamos metod nuevos?
```markdown
[Delivery]->[StartegyPago]  <-[MercadoPago]
                            <-[CreditCard]
                            <-[DebitoAutomatico]    
```
### Se usa Strategy cuando 
- Existen muchos algoritmos para llevar a cabno una tares
- No es deseable codificarlos todos en la misma clase
- Etc...
### Relacion con otros patrones
```markdown
### Strategy y Adapter 

- Ejemplo: encriptacion de mensajes...
- Los adaptadores serian las implementaciones (algotitmo TEA y RC4)
```

## Patron STATE
- Ejemplo 1: Sistema de Alarma
LAs alamarmas opueden estar en diferentes estados(inactiva, activa, sleeping, y combinaciones).

- cuando se manda el mensaje trigger() se pasa de un estado a otro.

```markdown
[Alarm]
    - trigger():void
        ->[AlarmState]
            - trigger():void
            <-[ActivateState]
                -trigger():void
            <-[ÇRinginState]
                -trigger():void
            <-[InactiveState]
                -trigger():void
            <-[SleepinState]
                -trigger():void
```

-Ejemplo 2: Calculadora

#### Cuando usarlo 
- no debemos confundirlo con Strategy
- en el State hay mensaje que dependen del estado y otros no!!! eso no pasa en el Strategy
- Sino depende del Estado no hay que delegar!!!

```markdown
    [Context]->[State]
      -handle()  - handle()
                <-[ConcreteStateA]
                    - handle()
                <-[ConcreteStateB]
                    - handle()
                <-[ConcreteStateC]
                    - handle()
```
### en el caso de la CALCULADORA ES EL setValor()

