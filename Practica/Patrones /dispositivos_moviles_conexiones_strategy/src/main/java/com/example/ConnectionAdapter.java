package com.example;

public class ConnectionAdapter implements Connection {
    private Connection4G connection4G;

    public ConnectionAdapter(Connection4G connection4G) {
        this.connection4G = connection4G;
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
