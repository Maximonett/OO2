package com.example;

public class ConnectionAdapter implements Connection {
    private 4
    GConnection connection4G;

    public ConnectionAdapter(4GConnection connection4G){
        this.connection4G=connection4G;
    }

    @Override
    public String sendData(String data, Integer crc) {
        return connection4G.transmit(data, crc);
    }

    @Override
    public String pict() {
        return connection4G.symb();
    }
}
