## Catálogo de Code Smells y Detección mediante AST
Este documento recopila distintos problemas de diseño (bad smells) analizados a partir de fragmentos de código, detallando su nombre técnico y la lógica algorítmica estructurada para detectarlos recorriendo un Árbol de Sintaxis Abstracta (AST).

1. Parámetro sin uso (Unused Parameter)Código analizado:
```java
Javaf(x, y, z) {
    a = 3 + y;
    x * x + y * x;
}
```

Nombre del Code Smell: Parámetro sin uso / Unused Parameter.   Algoritmo de detección en el AST:Al leer la firma de una función, guardar los parámetros de entrada en un Set.   Recorrer el cuerpo de la función. Si un parámetro es utilizado (leído o invocado), eliminarlo del Set.   Al finalizar la función, si el Set no está vacío (!vacio), reportar el bad smell para los parámetros restantes.   

2. Ramas Idénticas (Identical Branches)Código analizado:

```java
Javaf(x) {
    a = x ? 3 : 3;
}
```

Nombre del Code Smell: Ramas idénticas / Identical Branches.   Algoritmo de detección en el AST:Recorrer el árbol buscando nodos de tipo "Operador Ternario" o sentencias If-Else.Guardar la expresión correspondiente a la rama verdadera (then).   Guardar la expresión correspondiente a la rama falsa (else).   Si expresion_verdadera == expresion_falsa, reportar el bad smell.   

3. Llamada a Método Duplicada (Duplicate Method Call)Código analizado:
```java
Javaf(y) {
    a = g.x() + g.x() + g.x();
}
```
Nombre del Code Smell: Llamada a método duplicada / Duplicate Method Call.   Algoritmo de detección en el AST:Recorrer el árbol analizando instrucción por instrucción (líneas de código completas).Por cada instrucción, inicializar un Set vacío.Al encontrar una Invocación a Método (ej. g.x()), verificar si ya existe en el Set actual.   Si ya existe, reportar el bad smell. Si no existe, agregarla al Set y continuar con la misma línea.4. Doble Negación (Double Negation)Código analizado:
```java
Javaf(y) {
    a = not not y;
}
```
Nombre del Code Smell: Doble Negación / Double Negation.   Algoritmo de detección en el AST:Recorrer el árbol buscando cualquier nodo que sea un Operador Unario de negación (not o !).Revisar su nodo hijo directo.Si el hijo directo es otro Operador Unario de negación, reportar el bad smell.

5. Declaración sin Efecto (Statement with no effect)Código analizado:
```java
Javaf(y, z) {
    z + 12;
}
```
Nombre del Code Smell: Declaración sin efecto / Pointless Statement.   Algoritmo de detección en el AST:Buscar nodos de tipo "Sentencia de Expresión" que conformen una línea completa de código.Mirar el operador principal de esa expresión.   Si el operador es matemático o lógico (+, -, ==, etc.) y carece de un operador de asignación (=) o una palabra reservada (return), reportar el bad smell.   

6. Chequeo de Tipos (Simulated Polymorphism)Código analizado:
```java
JavaelegirSueldo(empleado) {
    clase = empleado.class;
    clase.equals(pasante) ? empleado.setSueldo(20000);
    clase.equals(planta) ? empleado.setSueldo(50000);
}
```
Nombre del Code Smell: Chequeo de Tipos / Type Checking o Switch Statements.   Algoritmo de detección en el AST:Buscar nodos que soliciten el tipo o clase de un objeto (ej. .class, typeof, instanceof).   Si el resultado de dicha consulta se utiliza como condición directa para una ramificación (if, switch, ternario), reportar el bad smell por violación de polimorfismo.   

7. Bucle Desenrollado (Unrolled Loop)Código analizado:
```java
JavaagregarOnceNumeros(lista) {
    lista.agregar(1);
    lista.agregar(2);
    // ... repetido 11 veces
}
```
Nombre del Code Smell: Bucle desenrollado / Unrolled Loop (Código repetitivo).   Algoritmo de detección en el AST:Buscar bloques de instrucciones secuenciales.Identificar llamadas consecutivas comparando la instrucción actual con la anterior para ver si invocan al mismo método sobre el mismo objeto.   Incrementar un contador por cada coincidencia estructural (si se rompe el patrón, reiniciar a 0).Si el contador supera un umbral prestablecido (ej. 3 veces), reportar el bad smell.

8. Asignación a un Parámetro (Assignment to Parameter)Código analizado:
```java
JavanumeroTelefonoCompleto(telefono, numero) {
    numero = telefono.codigoArea + telefono.prefijo + telefono.numero;
}
```
Nombre del Code Smell: Asignación a un parámetro / Assignment to parameter.   Algoritmo de detección en el AST:Guardar todos los parámetros de entrada de la función en una lista.   Buscar nodos de Asignación (operador =).Si el Hijo Izquierdo de la asignación coincide con uno de los parámetros de la lista, reportar el bad smell.

9. Expresiones Lógicas Redundantes (Constant Conditions)Código analizado:
```java
Javaf(x,y) {
    x or not x ? y + 1;
    x and x ? y - 1;
    x ? x ? y - 1;
}
```
Nombre del Code Smell: Expresiones Lógicas Redundantes / Redundant Logical Expressions.   Algoritmo de detección en el AST (para los 3 casos):Tautología: Si el operador es OR, y un hijo es la negación exacta del otro.Operandos Idénticos: Si es un operador binario lógico (AND/OR) y su hijo_izquierdo == hijo_derecho.Condición Anidada: Si un nodo condicional evalúa una variable, y dentro de su rama verdadera (then) existe otro nodo condicional evaluando exactamente la misma variable.

10. Autoasignación (Self-assignment)Código analizado:
```java
Javaf(x) {
    x = x;
}
```
Nombre del Code Smell: Autoasignación / Self-assignment.Algoritmo de detección en el AST:Buscar nodos de Asignación (operador =).Comparar el Hijo Izquierdo (Left-Hand Side) con el Hijo Derecho (Right-Hand Side).Si hijo_izquierdo == hijo_derecho, reportar el bad smell.

11. Falta de Else / Condiciones Opuestas (Missing Else)Código analizado:
```java
Javaf(x,y) {
    x ? y - 1;
    not x ? y - 2;
}
```
Nombre del Code Smell: Falta de Else / Missing Else o Condiciones opuestas consecutivas.Algoritmo de detección en el AST:Identificar sentencias condicionales consecutivas dentro de un mismo bloque.Extraer la condición del primer nodo y la del segundo nodo.Si la segunda condición es exactamente la negación lógica (not) de la primera, reportar el bad smell.

12. Lista de Parámetros Larga (Long Parameter List)Código analizado:
```java
Javaf(a,b,c,d,e,f,g,h,i,j,k) {
    a+b+c+d+e+f+g+h+i+j+k;
}
```

Nombre del Code Smell: Lista de parámetros larga / Long Parameter List.Algoritmo de detección en el AST:Buscar nodos de Declaración de Método o Función.Contar la cantidad de parámetros en la lista de argumentos de entrada.Si el número de parámetros es mayor a un umbral de referencia (ej. 4), reportar el bad smell.

13. Delegación Trivial / Hombre del Medio (Middle Man)Código analizado:
```java
JavasomeOperation(x,y,z) {
    other.someOperation(x,y,z);
}
```

Nombre del Code Smell: Delegación Trivial / Middle Man.   Algoritmo de detección en el AST:Buscar nodos de Declaración de Método.Verificar que el cuerpo del método contenga exactamente una sola instrucción.Revisar si esa instrucción es una Invocación a Método sobre un objeto externo (other).   Si el nombre del método invocado y sus parámetros coinciden exactamente con la firma del método padre, reportar el bad smell.