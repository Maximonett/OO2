package com.example;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

public class SeguroMedicoTest {

    @Test
    public void testPedroPlanObligatorioSinCoseguro() {
        // Crear afiliado Pedro
        Afiliado pedro = new Afiliado(
                "Pedro",
                2, // familiares a cargo
                100000, // salario
                LocalDate.of(1998, 1, 1) // 27 años (aproximado)
        );

        // Asignar plan obligatorio
        PlanMedico planObligatorio = new PlanObligatorio();
        pedro.setPlanMedico(planObligatorio);

        // Calcular monto
        double monto = pedro.calcularMonto();

        // Verificar cálculo:
        // Monto fijo: $15.000
        // Cargo familiar: 2 * $3.500 = $7.000
        // Cobertura viajera: 1% de $100.000 = $1.000
        // Seguro internación: $0
        // Total: $23.000
        assertEquals(23000, monto, 0.01);

        System.out.println("=== Pedro con Plan Obligatorio (sin coseguro) ===");
        System.out.println("Monto a pagar: $" + monto);
    }

    @Test
    public void testPedroCambioAPlanIntegralSinCoseguro() {
        Afiliado pedro = new Afiliado("Pedro", 2, 100000, LocalDate.of(1998, 1, 1));

        // Cambiar a plan integral
        PlanMedico planIntegral = new PlanIntegral();
        pedro.setPlanMedico(planIntegral);

        double monto = pedro.calcularMonto();

        // Verificar cálculo:
        // Monto fijo: $22.000
        // Cargo familiar: (2 * $3.000) + (1% de $100.000) = $6.000 + $1.000 = $7.000
        // Cobertura viajera: 3% de $100.000 = $3.000
        // Seguro internación: 5% de $22.000 = $1.100
        // Total: $33.100
        assertEquals(33100, monto, 0.01);

        System.out.println("\n=== Pedro con Plan Integral (sin coseguro) ===");
        System.out.println("Monto a pagar: $" + monto);
    }

    @Test
    public void testPedroPlanIntegralConCoseguro() {
        Afiliado pedro = new Afiliado("Pedro", 2, 100000, LocalDate.of(1998, 1, 1));

        // Crear coseguro con 10% de descuento, ingresado hace 3 años
        Coseguro coseguro = new Coseguro(
                "Coseguro Familiar",
                10, // 10% de descuento
                LocalDate.of(2022, 1, 1), // hace 3 años
                500 // monto cobertura viajes
        );
        pedro.setCoseguro(coseguro);

        // Asignar plan integral
        PlanMedico planIntegral = new PlanIntegral();
        pedro.setPlanMedico(planIntegral);

        double monto = pedro.calcularMonto();

        // Verificar cálculo:
        // Monto base (sin coseguro): $33.100
        // Cargo familiar: $7.000
        // Descuento coseguro: 10% de $7.000 = $700
        // Total: $33.100 - $700 = $32.400
        assertEquals(32400, monto, 0.01);

        System.out.println("\n=== Pedro con Plan Integral (con coseguro 10%) ===");
        System.out.println("Monto a pagar: $" + monto);
    }

    @Test
    public void testPlanPremiumConCoseguro() {
        Afiliado afiliado = new Afiliado("María", 6, 150000, LocalDate.of(1990, 1, 1));

        // Coseguro con 15% de descuento, antigüedad de 5 años
        Coseguro coseguro = new Coseguro(
                "Coseguro Premium",
                15,
                LocalDate.now().minusYears(5),
                1000);
        afiliado.setCoseguro(coseguro);

        PlanMedico planPremium = new PlanPremium();
        afiliado.setPlanMedico(planPremium);

        double monto = afiliado.calcularMonto();

        // Verificar cálculo:
        // Monto fijo: $33.000
        // Cargo familiar: (6 - 4) * $2.800 = $5.600 (los primeros 4 son gratis)
        // Cobertura viajera: 1% de $150.000 = $1.500
        // Seguro internación: 5% de $33.000 = $1.650
        // Subtotal: $41.750
        // Descuento coseguro: 5 años * $10.000 = $50.000
        // Total: $41.750 - $50.000 = -$8.250 → $0 (no puede ser negativo)
        // Nota: El ejercicio no especifica si puede ser negativo, asumimos que sí
        assertEquals(-8250, monto, 0.01);

        System.out.println("\n=== María con Plan Premium (con coseguro 5 años) ===");
        System.out.println("Monto a pagar: $" + monto);
    }
}
