public interface EstadoRiesgo {

    void actualizar(Zona zona, double co2);

    void entrar(Zona zona);

    String nombre();
}