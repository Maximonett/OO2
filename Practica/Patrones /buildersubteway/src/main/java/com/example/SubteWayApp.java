package com.example;


public class SubteWayApp {
    public static void main(String[] args) {
        Sandwichero director =new Sandwichero();

        System.out.println("=== SUBTEWAY: CÁLCULO DE PRECIOS === \n");

        // sandwich clasico

        SandwichBuilder clasicoBuilder= new ClasicoBuilder();
        director.prepararSandwich(clasicoBuilder);
        Sandwich clasico= clasicoBuilder.getSandwich();
        System.out.println("🥪 Sandwich Clasico");
        clasico.mostrarDetalles();

        // 2. Sándwich Vegetariano
        SandwichBuilder vegetarianoBuilder = new VegetarianoBuilder();
        director.prepararSandwich(vegetarianoBuilder);
        Sandwich vegetariano = vegetarianoBuilder.getSandwich();
        System.out.println("🥗 Sándwich Vegetariano");
        vegetariano.mostrarDetalles();

        // 3. Sándwich Vegano
        SandwichBuilder veganoBuilder = new VeganoBuilder();
        director.prepararSandwich(veganoBuilder);
        Sandwich vegano = veganoBuilder.getSandwich();
        System.out.println("🌱 Sándwich Vegano");
        vegano.mostrarDetalles();

        // 4. Sándwich Sin TACC
        SandwichBuilder sinTaccBuilder = new SinTaccBuilder();
        director.prepararSandwich(sinTaccBuilder);
        Sandwich sinTacc = sinTaccBuilder.getSandwich();
        System.out.println("🌾 Sándwich Sin TACC");
        sinTacc.mostrarDetalles();

        // 5. Demostración de escalabilidad (Nuevo en el futuro)
        SandwichBuilder ketoBuilder = new KetoBuilder();
        director.prepararSandwich(ketoBuilder);
        Sandwich keto = ketoBuilder.getSandwich();
        System.out.println("🥓 Sándwich Keto (Nueva incorporación)");
        keto.mostrarDetalles();

    }
}