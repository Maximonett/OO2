# Resumen de Roles y Patrones: Caso Biblioteca (OO2 - UNLP)

En este diseño se aplica principalmente el patrón de diseño **Strategy**, el cual permite intercambiar algoritmos de exportación de forma dinámica sin modificar la clase principal.

---

## 📋 Tabla de Roles

| Componente | Rol en el Patrón | Descripción |
| :--- | :--- | :--- |
| **`Exporter`** (Interfaz) | **Strategy** (Abstracción) | Define el contrato común (`exportar`). Todas las estrategias deben seguir esta firma. |
| **`VoorheesExporter`** | **Concrete Strategy** | Implementación específica. Contiene la lógica manual para transformar socios a formato JSON. |
| **`Biblioteca`** | **Context** (Contexto) | Mantiene una referencia a un `Exporter`. Delega la tarea de exportación sin conocer los detalles internos. |
| **`Socio`** | **Domain Object** | Clase de dominio que contiene la información (nombre, email, legajo) que será exportada. |

---

### 1. Patrón Strategy

Permite que la `Biblioteca` sea independiente de cómo se exportan los datos. Si necesitas exportar a XML, solo creas un `XmlExporter` que implemente la interfaz, sin tocar la clase `Biblioteca`.

```java
    Biblioteca biblioteca = new Biblioteca();
// Usa Voorhees por defecto
biblioteca.exportarSocios(); 

// Cambiamos la estrategia sobre la marcha
biblioteca.setExporter(new NuevoExporterDePDF()); 
biblioteca.exportarSocios(); // Ahora exporta PDF sin cambiar la clase Biblioteca
```

### 2. Inyección de Dependencias
A través del método `setExporter(Exporter exporter)`, puedes cambiar el comportamiento de la aplicación en tiempo de ejecución (Runtime).



### 3. Encapsulamiento y Formateo
La clase `VoorheesExporter` encapsula los detalles técnicos del formato:
* **`StringBuilder`**: Para una concatenación de texto eficiente.
* **`System.lineSeparator()`**: Para asegurar que los saltos de línea funcionen en cualquier sistema operativo.
* **`setLength()`**: Para eliminar la última coma sobrante y generar un JSON válido.

---
