public class Alerta implements EstadoRiesgo {

    @Override
    public void actualizar(Zona zona, double co2) {

        if (co2 >= 1200) {

            zona.cambiarEstado(new Emergencia());

        } else if (co2 < 800 && co2 >= 500) {

            zona.cambiarEstado(new Precaucion());

        } else if (co2 < 500) {

            zona.cambiarEstado(new Normal());
        }
    }

    @Override
    public void entrar(Zona zona) {

        System.out.println(
            "LOG: La zona ingresó en ALERTA."
        );

        System.out.println(
            "WHATSAPP: Aviso al equipo de respuesta."
        );
    }

    @Override
    public String nombre() {

        return "Alerta";
    }
}