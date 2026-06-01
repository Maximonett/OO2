package com.example;

public class Mensajero {
    private CipherStrategy cipher;
    private String claveActual;

    public Mensajero(CipherStrategy cipher, String claveActual) {
        this.cipher = cipher;
        this.claveActual = claveActual;
    }

    public void enviar(String mensaje) {
        if (claveActual == null) {
            throw new IllegalStateException("Debe configurar una clave antes de enviar");
        }
        String cifrado = cipher.encrypt(mensaje, claveActual);
        System.out.println("Enviado " + cifrado);

    }

    public void recibir(String mensajeCifrado) {
        if (claveActual == null) {
            throw new IllegalStateException("Debe configurar una clave antes de recibir");
        }
        String original = cipher.decrypt(mensajeCifrado, claveActual);
        System.out.println("Recibido " + original);
    }

    // Configuración dinámica
    public void setCipher(CipherStrategy cipher) {
        this.cipher = cipher;
    }

    public void setClave(String clave) {
        this.claveActual = clave;
    }
}
