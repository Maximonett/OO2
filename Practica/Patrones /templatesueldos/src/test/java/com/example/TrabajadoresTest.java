package com.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TrabajadoresTest {
    Pasante pasante1;
    Pasante pasante2;
    Temporario temporario1;
    Temporario temporario2;
    Temporario temporario3;
    Temporario temporario4;
    Planta planta1;
    Planta planta2;
    Planta planta3;
    Planta planta4;
    Planta planta5;
    Planta planta6;
    Planta planta7;
    Planta planta8; 

    @BeforeEach
    public void setUp() {
        pasante1 = new Pasante(0);
        pasante2 = new Pasante(3);

        temporario1 = new Temporario(0, true, 0);
        temporario2 = new Temporario(0, false, 0);
        temporario3 = new Temporario(20, true, 3);
        temporario4 = new Temporario(20, false, 3);

        planta1 = new Planta(0, false, 0, 0);
        planta2 = new Planta(0, true, 0, 0);
        planta3 = new Planta(0, false, 0, 10);
        planta4 = new Planta(0, true, 0, 10);
        planta5 = new Planta(0, false, 3, 10);
        planta6 = new Planta(0, true, 3, 10);
        planta7 = new Planta(1, false, 3, 0);
        planta8 = new Planta(1, true, 3, 0);
    }

    @Test
    public void testCalcularSueldoPasante() {
        // Pasantes (Básico: 20000)
        assertEquals(17400.0, pasante1.calcularSueldo(), 0.01); // 20000 * 0.87 + 0
        assertEquals(23100.0, pasante2.calcularSueldo(), 0.01); // 20000 * 0.87 + 6000 * 0.95

        // Temporarios (Básico: 20000 + horas * 300)
        assertEquals(22150.0, temporario1.calcularSueldo(), 0.01); // (20000 * 0.87) + (5000 * 0.95)
        assertEquals(17400.0, temporario2.calcularSueldo(), 0.01); // (20000 * 0.87) + 0
        assertEquals(33070.0, temporario3.calcularSueldo(), 0.01); // (26000 * 0.87) + (11000 * 0.95)
        assertEquals(28320.0, temporario4.calcularSueldo(), 0.01); // (26000 * 0.87) + (6000 * 0.95)

        // Planta (Básico: 50000 fijo)
        assertEquals(43500.0, planta1.calcularSueldo(), 0.01); // 50000 * 0.87 + 0
        assertEquals(48250.0, planta2.calcularSueldo(), 0.01); // 43500 + (5000 * 0.95)
        assertEquals(62500.0, planta3.calcularSueldo(), 0.01); // 43500 + (20000 * 0.95)
        assertEquals(67250.0, planta4.calcularSueldo(), 0.01); // 43500 + (25000 * 0.95)
        assertEquals(68200.0, planta5.calcularSueldo(), 0.01); // 43500 + (26000 * 0.95)
        assertEquals(72950.0, planta6.calcularSueldo(), 0.01); // 43500 + (31000 * 0.95)
        assertEquals(49200.0, planta7.calcularSueldo(), 0.01); // 43500 + (6000 * 0.95)
        assertEquals(53950.0, planta8.calcularSueldo(), 0.01); // 43500 + (11000 * 0.95)
    }
}