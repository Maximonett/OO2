### 2. Smell: La primera asignación no tiene efecto
En el segundo árbol, las asignaciones están representadas por los nodos stat:1. El smell ocurre cuando hay dos nodos stat:1 consecutivos en el mismo bloque que asignan un valor a la misma variable de forma contigua.
```JavaScript
funcion visitDef1(nodoDef) {
    // Se obtienen todas las sentencias dentro del bloque de la función
    listaSentencias = nodoDef.getStatements()

    para i desde 0 hasta listaSentencias.length - 2 {
        sentenciaActual = listaSentencias[i]
        sentenciaSiguiente = listaSentencias[i+1]

        // Verificar si ambas sentencias son del tipo asignación (stat:1)
        si (sentenciaActual.tipo == "stat:1" y sentenciaSiguiente.tipo == "stat:1") {
            
            // Obtener el nombre de la variable (el hijo izquierdo de la asignación)
            varActual = sentenciaActual.getChild(0).getText() // Ej: "a"
            varSiguiente = sentenciaSiguiente.getChild(0).getText() // Ej: "a"

            si (varActual == varSiguiente) {
                reportarSmell("La primera asignación a la variable '" + varActual + "' no tiene efecto")
            }
        }
    }
    visitChildren(nodoDef)
}
```