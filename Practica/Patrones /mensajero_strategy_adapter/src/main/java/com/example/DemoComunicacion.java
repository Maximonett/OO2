package com.example;

public class DemoComunicacion {
    public static void main(String[] args) {

        // === ALICE envía a BOB ===
        System.out.println("=== COMUNICACIÓN ALICE → BOB ===\n");

        // Alice configura su mensajero
        Mensajero alice = new Mensajero(new FeistelCipherAdapter(), "ClaveCompartida");

        // Bob configura su mensajero (debe usar el mismo cifrador y clave)
        Mensajero bob = new Mensajero(new FeistelCipherAdapter(), "ClaveCompartida");

        // Alice envía
        String mensajeAlice = " Hola Bob, ¿cómo estás? ";
        System.out.print(" Alice: ");
        alice.enviar(mensajeAlice);

        // Bob recibe (simulamos que llega el cifrado)
        String cifrado = alice.cifrarParaPrueba(mensajeAlice);
        System.out.print(" Bob:   ");
        bob.recibir(cifrado);

        // === CAMBIAN DE ALGORITMO POR SEGURIDAD ===
        System.out.println("\n=== CAMBIANDO A RC4 POR SEGURIDAD ===\n");

        alice.setCipher(new RC4CipherAdapter());
        bob.setCipher(new RC4CipherAdapter());
        alice.setClave("NuevaClaveRC4");
        bob.setClave("NuevaClaveRC4");

        // Alice envía con nuevo cifrador
        String mensajeAlice2 = " Cambié a RC4 para más seguridad ";
        System.out.print(" Alice: ");
        alice.enviar(mensajeAlice2);

        // Bob recibe con nuevo cifrador
        String cifrado2 = alice.cifrarParaPrueba(mensajeAlice2);
        System.out.print("Bob:   ");
        bob.recibir(cifrado2);
    }
}