package com.example;

public class WifiConn implements Connection {
    private String pict;

    public WifiConn() {
        this.pict = "🛜";
    }

    @Override
    public String sendData(String data, Integer crc) {
        return "WiFi enviando: " + data + " CRC: " + crc;
    }

    @Override
    public String pict() {
        return pict;
    }
}
