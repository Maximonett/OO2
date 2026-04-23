# Malos Olores y Refactorizaciones

---

## Página 1

**La siguiente tabla:**

| Mal Olor (Smell) | Refactorización |
| :--- | :--- |
| **Clases Alternativas con Diferentes Interfaces** | Renombrar Método, Mover Método |
| **Comentarios** | Extraer Superclase, Renombrar Método, Extraer Método, Introducir Afirmación |
| **Clase de Datos** | Mover Método, Encapsular Campo, Encapsular Colección, Eliminar Método de Configuración, Extraer Método |
| **Grupos de Datos (Data Clumps)** | Ocultar Método, Extraer Clase, Preservar Objeto Completo, Introducir Objeto de Parámetro |
| **Cambio Divergente** | Extraer Clase |
| **Código Duplicado** | Extraer Método, Subir Campo, Formar Método Plantilla, Sustituir Algoritmo, Extraer Clase |
| **Envidia de Funcionalidades / Clase Perezosa (Freeloader)** | Introducir Objeto Nulo, Extraer Método, Mover Método, Mover Campo, Colapsar Jerarquía, Clase en Línea |
| **Intimidad Inapropiada** | Mover Método, Mover Campo, Cambiar Asociación Bidireccional a Unidireccional, Extraer Clase |
| **Clase de Biblioteca Incompleta** | Ocultar Delegado, Reemplazar Herencia con Delegación, Introducir Método Externo, Introducir Extensión Local |
| **Clase Grande** | Extraer Clase, Extraer Subclase, Extraer Interfaz, Reemplazar Valor de Dato con Objeto |
| **Método Largo** | Extraer Método, Introducir Objeto de Parámetro, Descomponer Condicional, Preservar Objeto Completo, Reemplazar Método con Objeto de Método |
| **Lista de Parámetros Larga** | Reemplazar Temporal con Consulta, Reemplazar Parámetro con Método, Introducir Objeto de Parámetro, Preservar Objeto Completo |
| **Cadenas de Mensajes** | Ocultar Delegado, Extraer Método, Mover Método |
| **Hombre Intermedio (Middle Man)** | Eliminar Hombre Intermedio |

---

## Página 2

**La siguiente tabla:**

| Mal Olor (Smell) | Refactorización |
| :--- | :--- |
| **(Continuación Middle Man)** | Método en Línea, Reemplazar Delegación con Herencia |
| **Jerarquías de Herencia Paralelas** | Mover Método, Mover Campo |
| **Obsesión Primitiva** | Reemplazar Valor de Dato con Objeto, Introducir Objeto de Parámetro, Extraer Clase, Reemplazar Código de Tipo con Clase, Reemplazar Código con Estado/Estrategia, Reemplazar Código de Tipo con Subclases, Reemplazar Arreglo con Objeto |
| **Legado Rechazado (Refused Bequest)** | Bajar Campo, Bajar Método, Reemplazar Herencia con Delegación |
| **Cirugía de Escopeta (Shotgun Surgery)** | Mover Método, Mover Campo, Clase en Línea |
| **Generalidad Especulativa** | Colapsar Jerarquía, Renombrar Método, Eliminar Parámetro, Clase en Línea |
| **Sentencia Switch** | Extraer Método, Mover Método, Reemplazar Código de Tipo con Subclases, Reemplazar Código de Tipo con Estado/Estrategia, Reemplazar Condicional con Polimorfismo, Reemplazar Parámetro con Métodos Explícitos, Introducir Objeto Nulo |
| **Campo Temporal** | Extraer Clase, Introducir Objeto Nulo |