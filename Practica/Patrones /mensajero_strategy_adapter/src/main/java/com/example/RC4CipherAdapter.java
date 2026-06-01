package com.example;

public class RC4CipherAdapter implements CipherStrategy {
    private final RC4 rc4;

    public RC4CipherAdapter() {
        this.rc4 = new RC4();
    }

    @Override
    public String encrypt(String message, String key) {
        // Delegamos directamente al método de RC4
        // Solo adaptamos el nombre del método
        return rc4.encriptar(message, key);

    }

    @Override
    public String decrypt(String cipherText, String key) {
        return rc4.desencriptar(cipherText, key);
    }
}
