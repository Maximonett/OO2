public class Emergencia implements EstadoRiesgo {

    @Override
    public void actualizar(Zona zona, double co2) {

        if (co2 < 500) {

            zona.cambiarEstado(new Normal());

        } else if (co2 < 800) {

            zona.cambiarEstado(new Precaucion());

        } else if (co2 < 1200) {

            zona.cambiarEstado(new Alerta());
        }
    }

    @Override
    public void entrar(Zona zona) {

        System.out.println(
            "WHATSAPP URGENTE: Aviso al equipo de respuesta."
        );
    }

    @Override
    public String nombre() {

        return "Emergencia";
    }
}