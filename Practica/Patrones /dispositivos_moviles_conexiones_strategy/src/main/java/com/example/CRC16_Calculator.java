package com.example;

public class CRC16_Calculator implements CRCCalculator {
    @Override
    public Integer crcFor(String datos) {
        int crc = 0xFFFF;
        byte[] bytes = datos.getBytes();
        for (byte b : bytes) {
            crc = ((crc >>> 8) | (crc << 8)) & 0xffff;
            crc ^= (b & 0xff);
            crc ^= ((crc & 0xff) >> 4);
            crc ^= (crc << 12) & 0xffff;
            crc ^= ((crc & 0xFF) << 5) & 0xffff;
        }
        return crc & 0xffff;
    }
}
