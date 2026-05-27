## Frameworks

```
Sirve para reutilizar codigo, es como un copy paste pero mas sofisticado. 

"Copy paste" --> Herencia y Polimorfismo--> Extraer y Delegar --> Librerias-->Frameworks
```

```
Conjunto de clases "semidesarrollada", "reusable" con un arquirtectura particular y un diseño para responder al requerimiento de un usaurio.
```

```
Un framework esta diseñado para proveer reuso de unna manera de ejecutar (arquitectura).Se provee codigo o se configura para que ejecute.
- Aplication Frmaework (tiene loop de control)
- Infrastructure Framework
- En todos los casos tiene un metodo (hilo) que implemente "Inversion de control" (Hollywood Principle).
```
## Framework de caja blanca

### Aplicacion: Servidores TCP

```
Es un programa que implementa una de las partes de la arquitectura Cliente/Servidor.
- Un servidor escucha un socket TCP (IP_adress+port) 
- Un cliente establece una conexion con el servidor para enviar mensajes (plain text).
- El servidor responde

EJEMPLOS
    -SMTPserver:mail
    -DayTimeServer:Fecha Actual
    -HTTPServer
    -Backend aplications
    - etc...
```

### Flujo de control (TIPICO)
```
1- Creo un socket (IP_adres+puerto)
2- Escucha el socket
3- Acetar el cliente -> Sesión
4- Recibier un mensaje
    a- Condicion -> Responder
    b !Condicion -> 
        i- Cerrar Sesion
        ii- goto "2"/loop infinito
```
```
Este flujo de control sirve para cualquier protocolo HTTP, ECHO, HASH,etc..
```

### Ejemplo..desde el Cliente: Fetch
```javaScript
async function obtenerDatos() {
  try {
    // 1. Iniciamos la petición (Estado: Pending)
    const respuesta = await fetch('https://api.ejemplo.com/usuarios');
    
    // 2. Validamos la respuesta del servidor
    if (!respuesta.ok) throw new Error("Error en el servidor");

    // 3. Transformamos la respuesta a JSON
    const datos = await respuesta.json();
    
    console.log("Datos recibidos:", datos);
  } catch (error) {
    console.error("Error en el flujo:", error);
  }
}
```

### Ejemplo desde el Servidor : Express(Js)
```javaScript
const express = require('express');
const app = express();

// El servidor "escucha" y espera una petición
app.get('/usuarios', async (req, res) => {
  try {
    // 1. Lógica de base de datos
    const listaUsuarios = await DB.find(); 
    
    // 2. Enviamos la respuesta al cliente
    res.status(200).json(listaUsuarios);
  } catch (err) {
    // 3. Manejo de errores
    res.status(500).send("Error interno");
  }
});
```
```
SimpleTCP es el Framework y EchoServer es la aplicacion que implemta.Este es un framework de Caja Blanca. Y se ve porque hay que completar con metodos, como handleLoop() en este caso.
- Se demanda conocimiento del mismo.
```
### HotSpots vs FrozenSpot

```
HotSpot esta pensada para ser modificada el comportamiento a lo largo del tiempo
cambia.

FrozenSpot parte del frmaework que es utilizada en todas las instanciaciones, no se puede cambiar.
```
