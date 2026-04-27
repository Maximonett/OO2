### ADAPTER

1. Estructura del Patrón
Para entenderlo, hay que identificar cuatro componentes clave:

* **Target (Objetivo): Es la interfaz (Exporter).

* **Client (Cliente): Es la clase que necesita el servicio (Biblioteca).

* **Adaptee (Adaptado): Es la clase externa o vieja que tiene la funcionalidad pero una interfaz incompatible (ej: JSONArray de JSON.simple). Puede ser Jakson

* **Adapter (Adaptador): Es la clase que creamos nosotros. Implementa Exporter pero por dentro llama a los métodos de la librería externa.