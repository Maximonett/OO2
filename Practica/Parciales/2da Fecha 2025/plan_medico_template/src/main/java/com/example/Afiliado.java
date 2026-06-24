package com.example;

import java.time.LocalDate;

public class Afiliado {
    private String nombre;
    private int familiaresACargo;
    private double salario;
    private LocalDate fechaNacimiento;
    private PlanMedico plan;
    private Coseguro coseguro;
    private LocalDate fechaContratacion;

    public Afiliado(String nombre, int familiaresACargo, double salario, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.familiaresACargo = familiaresACargo;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = LocalDate.now();
    }

    public LocalDate getFechaContratacion() {
        return fechaContratacion;
    }

    public int limitePrestaciones() {
        // Lógica para calcular límite de prestaciones
        return 100;
    }

    public double calcularMonto() {
        if (plan == null) {
            throw new IllegalStateException("El afiliado no tiene un plan asignado");
        }
        return plan.calcularMonto(familiaresACargo, salario, coseguro);
    }

    public void setPlanMedico(PlanMedico plan) {
        this.plan = plan;
    }

    public void setCoseguro(Coseguro coseguro) {
        this.coseguro = coseguro;
    }

    public String getNombre() {
        return nombre;
    }

    public int getFamiliaresACargo() {
        return familiaresACargo;
    }

    public double getSalario() {
        return salario;
    }
}