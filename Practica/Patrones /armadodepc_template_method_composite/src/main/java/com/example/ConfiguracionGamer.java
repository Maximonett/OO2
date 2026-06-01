package com.example;

import java.awt.Component;

public class ConfiguracionGamer extends ConfiguracionPC {

    public ConfiguracionGamer(Catalogo catalogo) {
        super(catalogo);
    }

    @Override
    protected void agregarProcesador(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("procesador Gamer"));
    }

    @Override
    protected void agregarMemoria(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("32gb"));
        equipo.agregar(catalogo.getComponente("32gb"));
    }

    @Override
    protected void agregarDisco(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("SSD 500gb"));
        equipo.agregar(catalogo.getComponente("SSD 1 TB"));
    }

    @Override
    protected void agregarGrafica(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("RTX 4090"));
    }

    @Override
    protected void agregarGabinete(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("Gabinete Gamer"));
    }

    protected void agregarExtras(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("pad termico"));
        equipo.agregar(catalogo.getComponente("cooler"));
        int fuente= (int)(equipo.getConsumo()*1.5);

        equipo.agregar(catalogo.getComponente("fuente " + fuente + " w");
    }

}
