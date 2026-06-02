package com.example;

public interface Connection {
    String sendData(String data, Integer crc);

    String pict();
}
