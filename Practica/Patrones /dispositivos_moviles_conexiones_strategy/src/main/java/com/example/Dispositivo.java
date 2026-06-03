package com.example;

public class Dispositivo {
    private CRCCalculator crcCalculator;
    private Connection connection;
    private Ringer ringer;
    private Display display;

    public Dispositivo(CRCCalculator crcCalculator, Connection connection, Ringer ringer, Display display) {
        this.crcCalculator = crcCalculator;
        this.connection = connection;
        this.ringer = ringer;
        this.display = display;
    }

    public Dispositivo(Connection connection, CRCCalculator crcCalculator) {
        this.connection = connection;
        this.crcCalculator = crcCalculator;
    }

    public String send(String data) {
        long crc = this.crcCalculator.crcFor(data);
        return this.connection.sendData(data, (int) crc);
    }

    // Metodo cambiar conexion
    public String conectarCon(Connection nuevaConexion) {
        this.connection = nuevaConexion;

        // Mostrar simbolo en pantalla
        String simbolo = nuevaConexion.pict();
        display.showBanner(simbolo);
        // hacer sonar
        ringer.ring();

        return "Conexion cambiada a " + simbolo;
    }

    // Configurar CRC
    public void configurarCRC(CRCCalculator nuevoCRC) {
        this.crcCalculator = nuevoCRC;
    }

    public void setRinger(Ringer ringer) {
        this.ringer = ringer;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public CRCCalculator getCrcCalculator() {
        return crcCalculator;
    }

    public Connection getConnection() {
        return connection;
    }

}
