package com.example;

public class Sumando extends Operando{

    @Override
    public void setValor(double unValor, Calculadora c){
        c.setValorAcumulado(c.getValorAcumulado()+unValor);
        c.setEstado(new Inicial());
    }
}

