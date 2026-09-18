public class Normal implements EstadoRiesgo {

    @Override
    public void actualizar(Zona zona, double co2) {

        if (co2 >= 1200) {

            zona.cambiarEstado(new Emergencia());

        } else if (co2 >= 800) {

            zona.cambiarEstado(new Alerta());

        } else if (co2 >= 500) {

            zona.cambiarEstado(new Precaucion());
        }
    }

    @Override
    public void entrar(Zona zona) {

        System.out.println(
            "LOG: La zona volvió a condiciones normales."
        );
    }

    @Override
    public String nombre() {

        return "Normal";
    }
}