package com.example;

package com.example;

import java.awt.Component;

public class ConfiguracionIntermedia extends ConfiguracionPC {

    public ConfiguracionIntermedia(Catalogo catalogo) {
        super(catalogo);
    }

    @Override
    protected void agregarProcesador(Equipo equipo) {
        equipo.agregar(
                catalogo.getComponente("procesador intermedio"));
    }

    @Override
    protected void agregarMemoria(Equipo equipo) {
        equipo.agregar(
                catalogo.getComponente("16 gb"));
    }

    @Override
    protected void agregarDisco(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("SSD 500gb"));
    }

    @Override
    protected void agregarGrafica(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("GTX 1650"));
    }

    @Override
    protected void agregarGabinete(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("Gabinete Intermedio"));
    }

    protected void agregarExtras(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("Fuente 800W"));
    }

}
