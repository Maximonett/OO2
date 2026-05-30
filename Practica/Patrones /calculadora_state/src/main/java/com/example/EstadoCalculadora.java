package com.example;

public interface EstadoCalculadora {
    public void mas(Calculadora c);
    public void menos(Calculadora c);
    public void por(Calculadora c);
    public void dividido(Calculadora c);
    public void setValor(double unValor,Calculadora c);
    public String getResultado(Calculadora c);
}
