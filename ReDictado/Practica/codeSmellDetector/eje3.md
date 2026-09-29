### 3. Smell: Parámetro "x" no es utilizado
En el tercer árbol, la definición de la función está en el nodo def:1. Para detectar este smell, se deben extraer los parámetros declarados en la firma de la función y luego buscar si existen referencias a esos parámetros dentro de los nodos del cuerpo de la función.
```JavaScript
funcion visitDef1(nodoDef) {
    // 1. Obtener los nombres de los parámetros definidos en f(x)
    parametros = nodoDef.getParameters() // Ej: ["x"]
    
    // 2. Utilizar una función auxiliar para recolectar todas las variables 
    //    que son leídas/utilizadas dentro del cuerpo de la función
    variablesUsadas = recolectarVariablesUtilizadas(nodoDef.getBody())

    // 3. Verificar si algún parámetro no se encuentra en la lista de variables usadas
    para cada param en parametros {
        si (param no esta en variablesUsadas) {
            reportarSmell("El parámetro '" + param + "' no es utilizado")
        }
    }
    
    visitChildren(nodoDef)
}

// Función auxiliar
funcion recolectarVariablesUtilizadas(nodoCuerpo) {
    listaVariables = []
    // Recorre todo el subárbol del cuerpo buscando nodos de tipo expresión 
    // que representen la lectura de una variable (ej: expr:1 en el dibujo)
    // y los agrega a listaVariables.
    retornar listaVariables
}
```