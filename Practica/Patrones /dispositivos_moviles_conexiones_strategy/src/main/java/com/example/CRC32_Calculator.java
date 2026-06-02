package com.example;

import java.util.zip.CRC32;

public class CRC32_Calculator
implemnts CRCCalculator
{

    @Override
    public Integer crcFor(String datos) {
        CRC32 crc = new CRC32();
        datos = "un mensaje";
        crc.update(datos.getBytes());
        return (int) crc.getValue();
    }
}
