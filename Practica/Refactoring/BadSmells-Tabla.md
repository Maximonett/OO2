# Bad Smells

# Guía de Refactoring - Objetos 2 (UNLP)

| Bad Smell | ¿Cómo lo reconozco? | Refactoring Principal |
| :--- | :--- | :--- |
| **Duplicate Code** | El mismo código (o muy parecido) está en dos o más lugares. | **Pull Up Method**, **Extract Method** o **Extract Superclass**. |
| **Long Method** | Un método que tiene demasiadas líneas o hace muchas cosas. | **Extract Method**. |
| **Large Class** | Una clase que intenta tener demasiadas responsabilidades. | **Extract Class** o **Extract Subclass**. |
| **Long Parameter List** | Un método que recibe una lista larga de parámetros. | **Replace Parameter with Method Call** o **Introduce Parameter Object**. |
| **Divergent Change** | Tenés que cambiar una misma clase por razones de negocio distintas. | **Extract Class**. |
| **Shotgun Surgery** | Un solo cambio te obliga a realizar pequeñas modificaciones en muchas clases. | **Move Method** o **Move Field**. |
| **Feature Envy** | Un método usa más datos de otra clase que de la suya propia. | **Move Method**. |
| **Data Clumps** | Grupos de datos que siempre aparecen juntos (ej. calle, nro, ciudad). | **Extract Class** o **Introduce Parameter Object**. |
| **Primitive Obsession** | Usar tipos básicos (int, String) para conceptos que deberían ser objetos. | **Replace Data Value with Object**. |
| **Switch Statements** | Muchos `if/else` o `switch` que dependen del tipo de objeto o clase. | **Replace Conditional with Polymorphism**. |
| **Lazy Class** | Una clase que no hace lo suficiente para justificar su existencia. | **Inline Class** o **Collapse Hierarchy**. |
| **Speculative Generality** | Código diseñado para soportar casos que "podrían" pasar en el futuro. | **Remove Parameter** o **Collapse Hierarchy**. |
| **Temporary Field** | Un atributo de clase que solo se usa (tiene valor) a veces. | **Extract Class**. |
| **Message Chains** | El código navega por varios objetos: `a.getB().getC().doSomething()`. | **Hide Delegate**. |
| **Middle Man** | Una clase que solo delega trabajo a otra sin agregar lógica propia. | **Remove Middle Man**. |
| **Inappropriate Intimacy** | Clases que conocen detalles demasiado privados una de la otra. | **Move Method**, **Move Field** o **Encapsulate Collection**. |
| **Comments** | El código es tan complejo que requiere explicaciones escritas. | **Extract Method** o **Rename Method**. |