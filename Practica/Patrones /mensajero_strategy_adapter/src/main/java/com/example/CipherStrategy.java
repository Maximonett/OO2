package com.example;

public interface CipherStrategy {
    String encrypt(String message, String key);

    String decrypt(String cipherText, String key);
}
