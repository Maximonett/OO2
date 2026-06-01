package com.example;

public class FeistelCipherAdapter implements CipherStrategy {
    private FeistelCipher feistelCipher;
    private String currentKey;

    public FeistelCipherAdapter() {
        this.feistelCipher = new FeistelCipher(currentKey);
    }

    // Método privado para manejar la creación/recreación del cipher
    private void ensureCipherWithKey(String key) {
        if (this.currentKey == null || !this.currentKey.equals(key)) {
            this.feistelCipher = new FeistelCipher(key);
            this.currentKey = key;
        }
    }

    @Override
    public String encrypt(String message, String key) {
        ensureCipherWithKey(key);
        return feistelCipher.encode(message);
    }

    @Override
    public String decrypt(String cipherText, String key) {
        ensureCipherWithKey(key);

        return feistelCipher.encode(cipherText);
    }
}
