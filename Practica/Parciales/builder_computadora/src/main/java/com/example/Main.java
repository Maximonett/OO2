public class Main {

    public static void main(String[] args) {

        Zona zona = new Zona("Laboratorio");

        Sensor sensor1 = new Sensor("Sensor 1", 400);

        Sensor sensor2 = new Sensor("Sensor 2", 400);

        zona.agregar(sensor1);

        zona.agregar(sensor2);

        System.out.println("Estado inicial: "
                + zona.getEstado().nombre());

        // CO2 promedio = 400
        zona.actualizarRiesgo();

        // CO2 promedio = 600
        sensor1.setValorCO2(600);
        sensor2.setValorCO2(600);

        zona.actualizarRiesgo();

        // CO2 promedio = 900
        sensor1.setValorCO2(900);
        sensor2.setValorCO2(900);

        zona.actualizarRiesgo();

        // CO2 promedio = 1300
        sensor1.setValorCO2(1300);
        sensor2.setValorCO2(1300);

        zona.actualizarRiesgo();

        // CO2 promedio = 400
        sensor1.setValorCO2(400);
        sensor2.setValorCO2(400);

        zona.actualizarRiesgo();
    }
}