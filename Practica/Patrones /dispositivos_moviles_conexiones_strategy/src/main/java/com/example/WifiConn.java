package com.example;

public class WifiConn implements Connection {
    private String pict;

    public WifiConn() {
        this.pict = "🛜";
    }

}

    @Override
    public String sendData(String data, Integer crc) {
        return "Wifi enviado " + data + "CRC: " + crc;
    }

@Override 
public String pict(){
    return pict;
}