package com.example;

public abstract class MixingTank {
    public abstract boolean heatPower(int percentage); // configura el nivel potencia de la fuente de calor del tanque
                                                       // de 0 a 100

    public abstract boolean mixerPower(int percentage);// configura el nivel de potencia de la mezcladora del tanque de
                                                       // 0 a 100

    public abstract boolean purge();// comanda al tanque para que se desagote

    public abstract double upTo();// retorna el volumen ocupado del tanque de 0 a 100

    public abstract double temperature();// retorna la temperatura del contenido del tanque
}
