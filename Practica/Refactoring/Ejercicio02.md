# Ejercicio 2: Iteradores circulares

### Tareas:
Se quiere aplicar el refactoring Rename Variable sobre la variable result que se usa en la línea 18 con el nuevo nombre currentPosition.
¿Cómo queda el código final y qué inconveniente se podría encontrar?

## Original
```java
 1   public class CharRing extends Object {
 2      char[] source;
 3      int idx;
 4  
 5      public CharRing(String srcString) {
 6          char result;
 7          source = new char[srcString.length()];
 8          srcString.getChars(0, srcString.length(), source, 0);
 9          result = 0;
10          idx = result;
11      }
12  
13      public char next() {
14          int result;
15          if (idx >= source.length)
16              idx = 0;
17          result = idx++;
18          return source[result];
19      }
20  }
```
### Solución

```java
 1   public class CharRing extends Object {
 2      char[] source;
 3      int idx;
 4  
 5      public CharRing(String srcString) {
 6          char result;
 7          source = new char[srcString.length()];
 8          srcString.getChars(0, srcString.length(), source, 0);
 9          result = 0;
10          idx = result;
11      }
12  
13      public char next() {
14          int currentPosition;
15          if (idx >= source.length)
16              idx = 0;
17          currentPosition = idx++;
18          return source[currentPosition];
19      }
20  }
```
## BadSmells: Remove Temporary Variable
### Solucion
Se elimina la variable "char result" del constructor y se inicializa directamente idx=0
```java
public class CharRing {

    char[] source;
    int idx;

    public CharRing(String srcString) {
        source = new char[srcString.length()];
        srcString.getChars(0, srcString.length(), source, 0);
        idx = 0; // simplificado
    }

    public char next() {
        int currentPosition;

        if (idx >= source.length)
            idx = 0;

        currentPosition = idx++;
        return source[currentPosition];
    }
}
```
