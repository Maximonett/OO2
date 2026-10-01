```mermaid
classDiagram
    class Director {
        -builder : Builder
        +Director(b: Builder)
        +construirMenuCompleto() void
        +construirMenuBasico() void
    }
    class Builder {
        <<Interface>>
        +setPaty(tipo: String) Builder
        +addIngrediente(ing: String) Builder
        +setAcompanamiento(acomp: String) Builder
        +build() Producto
    }
    class HamburguesaBuilder {
        -producto : Hamburguesa
        +setPaty(tipo: String) Builder
        +addIngrediente(ing: String) Builder
        +setAcompanamiento(acomp: String) Builder
        +build() Hamburguesa
    }
    class Hamburguesa {
        -paty : String
        -ingredientes : List
        -acompanamiento : String
    }

    Director o--> Builder
    HamburguesaBuilder ..|> Builder
    HamburguesaBuilder --> Hamburguesa : crea >
    ```