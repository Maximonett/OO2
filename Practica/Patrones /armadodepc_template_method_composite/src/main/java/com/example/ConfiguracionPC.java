package com.example;

public abstract class ConfiguracionPC {
    protected Catalogo catalogo;

    public ConfiguracionPC(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public Equipo armarEquipo() {

        Equipo equipo = new Equipo();

        agregarProcesador(equipo);
        agregarMemoria(equipo);
        agregarDisco(equipo);
        agregarGrafica(equipo);
        agregarGabinete(equipo);

        agregarExtras(equipo);

        return equipo;
    }

    protected abstract void agregarProcesador(Equipo equipo);

    protected abstract void agregarMemoria(Equipo equipo);

    protected abstract void agregarDisco(Equipo equipo);

    protected abstract void agregarGrafica(Equipo equipo);

    protected abstract void agregarGabinete(Equipo equipo);

    protected void agregarExtras(Equipo equipo) {
    }

}
