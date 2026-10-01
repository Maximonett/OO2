### 1. Smell: Ambas ramas del condicional son iguales
En el primer árbol, el operador ternario está representado por el nodo expr:20. El objetivo es comparar el nodo de la rama "verdadera" con el nodo de la rama "falsa".
```JavaScript

funcion visitExpr20(nodo) {
    // El nodo expr:20 tiene la estructura: expr '?' expr ':' expr
    // Asumiendo que los hijos se indexan desde 0:
    // hijo 0 = condición, hijo 1 = '?', hijo 2 = rama true, hijo 3 = ':', hijo 4 = rama false
    
    nodoRamaTrue = nodo.getChild(2)
    nodoRamaFalse = nodo.getChild(4)

    // Se compara el texto (código fuente) de ambas ramas
    si (nodoRamaTrue.getText() == nodoRamaFalse.getText()) {
        reportarSmell("Ambas ramas del condicional son iguales")
    }
    
    // Continuar recorriendo los hijos por si hay más condicionales anidados
    visitChildren(nodo)
}
```