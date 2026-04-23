# Ejercicio 5: Productos 
Se cuenta con un sistema que maneja una jerarquía de productos que pueden ser estadías de hoteles o alquileres de autos. En el siguiente material adicional puede descargar un proyecto con las clases implementadas. Observe que el proyecto cuenta con test unitarios que verifican el funcionamiento correcto de la aplicación. A continuación se muestra un extracto del código:

 1- La variable “cost” está declarada como pública, lo que rompe el encapsulamiento de la clase. Utilice el refactoring Encapsulate Field y describa brevemente los pasos llevados a cabo. Verifique que los tests provistos sigan funcionando. Discuta con un ayudante: 
 ¿Es correcto modificar alguno de los tests para que el código refactorizado funcione? En caso de qué el test falle, ¿qué situación está representando este test?
```
Se cambio las variables cost en las clases "HotelStay" y en la clase "CarRental" a privadas y se hicieron metodos getCost() en ambas dos. De esta manera se logro el encapsulamiento y los Test pasaron perfectamente.
```
2-Utilice el refactoring Rename Field en el método priceFactor(), para que la variable “cost” se pase a llamar “quote”. Verifique que los tests provistos sigan funcionando. Discuta con un ayudante: ¿en este caso, es necesario modificar alguno de los tests para que el código refactorizado funcione?

````java
    package ar.edu.info.unlp.refactoring.ejercicio1;

import java.time.LocalDate;

public class HotelStay extends Product {
    private double cost;
    private TimePeriod timePeriod;
    private Hotel hotel;

    public HotelStay(double cost, TimePeriod timePeriod, Hotel hotel) {
        this.cost = cost;
        this.timePeriod = timePeriod;
        this.hotel = hotel;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }

    public double priceFactor() {
        return this.cost / this.price();
    }

    public double price() {
        return this.timePeriod.duration() * this.hotel.nightPrice() * this.hotel.discountRate();
    }

    public double getCost() {
        return this.cost;
    }    
}

```
#### Rename Field en la variabel cost por quote.
````java
package ar.edu.info.unlp.refactoring.ejercicio1;

import java.time.LocalDate;

public class HotelStay extends Product {
    private double quote;
    private TimePeriod timePeriod;
    private Hotel hotel;

    public HotelStay(double cost, TimePeriod timePeriod, Hotel hotel) {
        this.quote = quote;
        this.timePeriod = timePeriod;
        this.hotel = hotel;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }

    public double priceFactor() {
        return this.quote / this.price();
    }

    public double price() {
        return this.timePeriod.duration() * this.hotel.nightPrice() * this.hotel.discountRate();
    }

    public double getCost() {
        return this.qote;
    }    
}
```
````
    En el Rename Field se hizo solamente en la variable ye sto no genero problemas con los test.. pero si se hubiese hecho con los metodos tambien como getCost() por getQuote() si hubiese sido otro problema para Refactorizar ya que habia que modifcar las test.
```

3-Se quiere aplicar el refactoring Pull Up Method para subir los métodos startDate() y endDate() a la superclase Product. ¿Es posible hacerlo en el código anterior? Justifique su respuesta basándose en las precondiciones del refactoring vistas en la teoría y en el libro de Refactoring de Martin Fowler.
4 y 5
Mencione y aplique los refactorings necesarios para poder hacer Pull Up Method.
Aplique Pull Up Method para subir los métodos a la superclase Product. Verifique que los tests provistos sigan funcionando.

````
Despues de analizar la subclases "CarRental" y "HotelStay" podemos ver que poseen dos metodos iguales los cuales son startDate() y endDate(), la cual es premisa para poder hacer el Refactoring de Pull Up Method. Pero primero necesitamos hacer un Pull Up Field de la variable "timePeriod".
```
## ERA TAN NECESARIO EL PULL UP ??? LA CLASE CARRENTAL NO LA USA A LA VARIABLE.

### Codigo antes del Pull Up Field y del Pull Up Method
```

````java
    package ar.edu.info.unlp.refactoring.ejercicio1;

public class Product {

}

public class CarRental extends Product {
    private double cost;
    private TimePeriod timePeriod;
    private Company company;

    public CarRental(double cost, TimePeriod timePeriod, Company company) {
        this.cost = cost;
        this.timePeriod = timePeriod;
        this.company = company;
    }

    public double price() {
        return this.company.price() * this.company.promotionRate();
    }

    public double getCost() {
        return this.cost;
    }
}

public class HotelStay extends Product {
    private double quote;
    private TimePeriod timePeriod;
    private Hotel hotel;

    public HotelStay(double quote, TimePeriod timePeriod, Hotel hotel) {
        this.quote = quote;
        this.timePeriod = timePeriod;
        this.hotel = hotel;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }

    public double priceFactor() {
        return this.quote / this.price();
    }

    public double price() {
        return this.timePeriod.duration() * this.hotel.nightPrice() * this.hotel.discountRate();
    }

    public double getCost() {
        return this.quote;
    }    
}
````

## Pull Up Field

## Pull Up Method despues ...
```java
    public class Product {
    protected TimePeriod timePeriod;

    public Product(TimePeriod timePeriod) {
        this.timePeriod = timePeriod;
    }

    public LocalDate startDate() {
        return this.timePeriod.start();
    }

    public LocalDate endDate() {
        return this.timePeriod.end();
    }

    public TimePeriod getTimePeriod() {
        return this.timePeriod;
    }

}

```
````java
    public class CarRental extends Product {
    private double cost;
    private TimePeriod timePeriod;
    private Company company;

    public CarRental(double cost, TimePeriod timePeriod, Company company) {
        super(timePeriod);
        this.cost = cost;
        this.company = company;
    }   

    public double price() {
        return this.company.price() * this.company.promotionRate();
    }

    public double getCost() {
        return this.cost;
    }
}
```
````
```java
    public class HotelStay extends Product {
    private double quote;
    private Hotel hotel;

    public HotelStay(double quote, TimePeriod timePeriod, Hotel hotel) {
        super(timePeriod);
        this.quote = quote;
        this.hotel = hotel;
    }

    public double priceFactor() {
        return this.quote / this.price();
    }

    public double price() {
        return this.getTimePeriod().duration() * this.hotel.nightPrice() * this.hotel.discountRate();
    }

    public double getCost() {
        return this.quote;
    }    
}

```

6-Observe los métodos price() en CarRental.java (línea 21) y en HotelStay.java (línea 25). Identifique los Code Smell presentes. Luego aplique los refactoring correspondientes para eliminarlos. Verifique que los tests provistos sigan funcionando.
```
1. Feature Envy (Envidia de Atributos)
Este es el smell más evidente. Una clase usa excesivamente métodos de otra para realizar un cálculo.

En CarRental: El método price() hace this.company.price() * this.company.promotionRate().

En HotelStay: Hace this.hotel.nightPrice() * this.hotel.discountRate().

Por qué es un problema: CarRental sabe cómo se calcula el precio de una compañía. Si mañana la compañía cambia su política de promociones, tenés que modificar CarRental. La responsabilidad del cálculo debería estar en Company y Hotel.

2. Inappropriate Intimacy (Intimidad Inapropiada)
HotelStay no solo pide un dato, sino que pide varios (nightPrice, discountRate) y realiza la operación aritmética ella misma. Está demasiado acoplada a la estructura interna de Hotel.

3. Rompe el principio "Tell, Don't Ask" (Decile, no le preguntes)
En lugar de preguntarle al Hotel sus valores para calcular el total, deberías decirle al hotel que calcule el precio para una duración determinada.

4. Duplicación de Lógica (Code Duplication)
Ambos métodos price() multiplican un valor base por una tasa de descuento/promoción (promotionRate vs discountRate). Aunque los nombres cambian, la semántica es la misma. Esto sugiere que podrías tener una abstracción común o un nombre de método unificado en las clases de destino.

¿Cómo refactorizarlo? (Solución propuesta)
Para solucionar esto, aplicamos Move Method. La lógica del cálculo se mueve a la clase que tiene los datos.

En las clases de soporte:
Hotel: Debería tener un método calculatePrice(int days).

Company: Debería tener un método calculatePrice().

En las clases de productos:
Java
// En CarRental
public double price() {
    // Solo delegamos
    return this.company.calculateTotal(); 
}

// En HotelStay
public double price() {
    // Le pasamos lo que el hotel NO sabe (la duración), 
    // pero el hotel hace la cuenta.
    return this.hotel.calculatePriceFor(this.getTimePeriod().duration());
}
Un detalle extra sobre Product
Noté que Product tiene el atributo protected TimePeriod timePeriod. En el examen o entregas de la UNLP, recordá que se prefiere el uso de getters incluso dentro de la jerarquía para mantener el encapsulamiento. Ya tenés getTimePeriod(), así que podrías poner el atributo como private.

Pregunta de diseño: ¿Viste que CarRental usa cost y HotelStay usa quote? Si ambos representan lo mismo (el precio pactado), ese atributo debería subir a la clase Product para evitar la duplicación de getCost().

¿Te suena el concepto de Pull Up Field para resolver esa diferencia entre cost y quote?
````