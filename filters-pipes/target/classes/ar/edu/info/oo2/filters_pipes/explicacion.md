# Análisis filters-pipes

## Parte 1 — ¿Qué patrón son los Pipes?

### TemplateMethod
**¿Se distingue el objetivo?** No. Template Method define el esqueleto de un algoritmo
en una clase base y deja que subclases rellenen pasos variables. En los pipes no hay un
algoritmo con pasos — todos hacen lo mismo: aplicar su filtro y delegar al siguiente.

**¿Coincide la estructura?** No hay subclases que sobreescriban pasos de `filter()`.
`EndPipe` e `ImageFilterPipe` difieren en comportamiento completo, no en pasos parciales
de un mismo algoritmo. No aplica.

---

### Strategy
**¿Se distingue el objetivo?** Solo parcialmente. `ImageFilter` como interfaz permite
intercambiar algoritmos de transformación — eso es Strategy en los filtros concretos.
Pero el sistema de pipes agrega composición y encadenamiento que Strategy no describe.

**¿Coincide la estructura?** Strategy encapsula UN algoritmo intercambiable en un contexto.
Acá no hay un contexto que delega a una sola estrategia, hay una cadena de pipes que se
llaman entre sí. No es el patrón dominante.

---

### Decorator ✓
**¿Se distingue el objetivo?** Sí. El objetivo es agregar comportamiento de forma
incremental y componible sin modificar los objetos base. `ImageFilterPipe` implementa
`ImageFilter` (mismo tipo que lo que contiene) y añade el paso de encadenar al siguiente
— exactamente la intención del Decorator.

**¿Coincide la estructura?**

| Rol (patrón)      | Clase en el diseño                                  |
|-------------------|-----------------------------------------------------|
| Component         | `ImageFilter`                                       |
| ConcreteComponent | `Rainbow`, `Monochrome`, `Artifacter`, etc.         |
| Decorator         | `ImageFilterPipe`                                   |
| Fin de cadena     | `EndPipe`                                           |

**Smell respecto al libro:** En el Decorator canónico se construye de adentro hacia afuera
al instanciar: `new Pipe(mono, new Pipe(repeater, new Pipe(rgb, end)))`. Acá en cambio se
usa una lista enlazada con traversal recursivo (`addPipeFrom`) para agregar al final. Esto
fuerza que `ImageFilterPipeInterface` exponga métodos de estructura interna (`setNextPipe`,
`addPipeFrom`) que un Decorator puro no necesitaría. El resultado es un doble despacho
innecesario y una interfaz con responsabilidades de construcción que no le corresponden.

---

## Parte 2 — Diseño para el Ejercicio 22c

### Patrón: Abstract Factory

**Objetivo:** Proveer una interfaz para crear familias de objetos relacionados (secuencias
de filtros consistentes) sin exponer al cliente las reglas de construcción. El cliente solo
conoce la fábrica y llama sus métodos — las restricciones están encapsuladas adentro.

### Estructura y participantes

| Rol (patrón)      | Clase en el diseño              |
|-------------------|---------------------------------|
| AbstractFactory   | `FilterSequenceFactory`         |
| ConcreteFactory1  | `MultiChromeSequenceFactory`    |
| ConcreteFactory2  | `MonoChromeSequenceFactory`     |
| AbstractProduct   | `ImageFilter` (la secuencia)    |
| Client            | `PNGFilterLauncher`             |

`FilterSequenceFactory` declara métodos `addRainbow()`, `addMonochrome()`,
`addArtifacter()`, `addRGBShifter()`, `addRepeater()` y `build()`. Los métodos sin
restricciones entre familias pueden tener implementación default en la clase abstracta.

`MultiChromeSequenceFactory` implementa `addRainbow()` normalmente e ignora/advierte
en `addMonochrome()`.

`MonoChromeSequenceFactory` ignora/advierte en `addRainbow()`, ignora `addMonochrome()`
explícito, y en `build()` fuerza `Monochrome` como último paso antes de retornar.

`PNGFilterLauncher` instancia la fábrica correcta según un flag (`--multichrome` /
`--monochrome`) y le delega la adición de filtros — nunca construye la secuencia
directamente.

### Smells o desvíos del patrón

- En el Abstract Factory del libro, cada método crea un producto distinto
  (`createButton()`, `createCheckbox()`). Acá los métodos son "pasos de construcción"
  — eso se acerca más al patrón **Builder**. La diferencia es que Abstract Factory crea
  familias de productos independientes, mientras que Builder arma un objeto complejo
  paso a paso. En este diseño se usan las dos ideas mezcladas.

- Un smell potencial: si en el futuro se agregan muchos filtros, la fábrica abstracta
  crece con un método por filtro — violando el Principio Abierto/Cerrado si agregar un
  filtro nuevo requiere modificar la interfaz de la fábrica.

- Otro smell: `addMonochrome()` en `MonoChromeSequenceFactory` hace silenciosamente
  nada cuando el cliente la llama. Eso puede sorprender al usuario de la API — sería
  más explícito lanzar una excepción o directamente no exponer ese método en esa fábrica.
