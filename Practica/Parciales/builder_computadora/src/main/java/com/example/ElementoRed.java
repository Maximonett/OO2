public abstract class ElementoRed {

    private String nombre;

    public ElementoRed(String nombre) {

        this.nombre = nombre;
    }

    public String getNombre() {

        return nombre;
    }

    public abstract double valorCO2();

    public abstract int cantidadSensores();

    public abstract String obtenerEstructura();
}