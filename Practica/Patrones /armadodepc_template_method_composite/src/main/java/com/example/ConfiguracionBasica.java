package com.example;

public class ConfiguracionBasica extends ConfiguracionPC {

    public ConfiguracionBasica(Catalogo catalogo) {
        super(catalogo);
    }

    @Override
    protected void agregarProcesador(Equipo equipo) {
        equipo.agregar(
                catalogo.getComponente("procesador basico"));
    }

    @Override
    protected void agregarMemoria(Equipo equipo) {
        equipo.agregar(
                catalogo.getComponente("8 gb"));
    }

    @Override
    protected void agregarDisco(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("HHD 500Gb"));
    }

    @Override
    protected void agregarGrafica(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("No posse(integrada)"));
    }

    @Override
    protected void agregarGabinete(Equipo equipo) {
        equipo.agregar(catalogo.getComponente("Gabinete Estandar"));
    }

    protected void agregarExtras(Equipo equipo) {
    }
}
