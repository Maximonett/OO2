package com.example;

public class 4GConnection {
    private String symb;
    
    public 4GConnection(){
        this.symb="4G";
    }

    public String transmit(String data, Integer crc){
        return "4G transmitiendo: " + data + " CRC "+crc;
    }
    public String symb(){
        return symb;
    }
}
