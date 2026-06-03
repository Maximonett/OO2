package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DispositivoTest {

    @Test
    public void testSendConWiFi_Y_CRC16() {
        Connection wifi = new WifiConn();
        CRCCalculator crc16 = new CRC16_Calculator();
        Dispositivo dispositivo = new Dispositivo(wifi, crc16);

        String resultado = dispositivo.send("Hola Mundo");

        assertNotNull(resultado);
        assertTrue(resultado.contains("WiFi enviando"));
        assertTrue(resultado.contains("Hola Mundo"));
    }

    @Test
    public void testSendCon4G_Y_CRC32() {
        Connection4G conn4G = new Connection4G();
        Connection adapter = new ConnectionAdapter(conn4G);
        CRCCalculator crc32 = new CRC32_Calculator();
        Dispositivo dispositivo = new Dispositivo(adapter, crc32);

        String resultado = dispositivo.send("Datos 4G");

        assertNotNull(resultado);
        assertTrue(resultado.contains("4G transmitiendo"));
        assertTrue(resultado.contains("Datos 4G"));
    }

    @Test
    public void testConectarCon_CambiaDeWiFiA4G() {
        Connection wifi = new WifiConn();
        Connection4G conn4G = new Connection4G();
        Connection adapter4G = new ConnectionAdapter(conn4G);

        Display mockDisplay = new Display();
        Ringer mockRinger = new Ringer();

        Dispositivo dispositivo = new Dispositivo(wifi, new CRC16_Calculator());
        dispositivo.setDisplay(mockDisplay);
        dispositivo.setRinger(mockRinger);

        String resultado = dispositivo.conectarCon(adapter4G);

        assertNotNull(resultado);
        assertTrue(resultado.contains("4G"));
        assertEquals(adapter4G, dispositivo.getConnection());
    }

    @Test
    public void testConfigurarCRC_CambiaDe16A32() {
        Connection wifi = new WifiConn();
        CRCCalculator crc16 = new CRC16_Calculator();
        Dispositivo dispositivo = new Dispositivo(wifi, crc16);

        assertTrue(dispositivo.getCrcCalculator() instanceof CRC16_Calculator);

        CRCCalculator crc32 = new CRC32_Calculator();
        dispositivo.configurarCRC(crc32);

        assertTrue(dispositivo.getCrcCalculator() instanceof CRC32_Calculator);
    }

    @Test
    public void testSend_UsaElCRCConfigurado() {
        Connection wifi = new WifiConn();
        Dispositivo dispositivo = new Dispositivo(wifi, new CRC16_Calculator());

        String datos = "Test";

        CRCCalculator crc16 = new CRC16_Calculator();
        CRCCalculator crc32 = new CRC32_Calculator();
        int crc16Value = crc16.crcFor(datos);
        int crc32Value = crc32.crcFor(datos);

        String resultado16 = dispositivo.send(datos);
        assertTrue(resultado16.contains(String.valueOf(crc16Value)));

        dispositivo.configurarCRC(crc32);

        String resultado32 = dispositivo.send(datos);
        assertTrue(resultado32.contains(String.valueOf(crc32Value)));
    }
}
