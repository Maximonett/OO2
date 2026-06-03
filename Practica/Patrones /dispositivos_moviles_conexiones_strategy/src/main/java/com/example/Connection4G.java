package com.example;

public class Connection4G {
    private String symb;

    public Connection4G() {
        this.symb = "4G";
    }

    public String transmit(String data, Integer crc) {
        return "4G transmitiendo: " + data + " CRC " + crc;
    }

    public String symb() {
        return symb;
    }
}
