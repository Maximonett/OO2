package com.example;

public class Main {
    public static void main(String[] args) {

        // Crear catálogo con componentes
        Catalogo catalogo = new Catalogo();

        // Procesadores
        catalogo.agregarComponente(new Componente("Procesador Basico", "procesador basico", 50000, 65));
        catalogo.agregarComponente(new Componente("Procesador Intermedio", "procesador intermedio", 120000, 95));
        catalogo.agregarComponente(new Componente("Procesador Gamer", "procesador Gamer", 250000, 125));

        // Memorias
        catalogo.agregarComponente(new Componente("RAM 8GB", "8 gb", 25000, 5));
        catalogo.agregarComponente(new Componente("RAM 16GB", "16 gb", 45000, 5));
        catalogo.agregarComponente(new Componente("RAM 32GB", "32gb", 80000, 5));

        // Discos
        catalogo.agregarComponente(new Componente("HDD 500GB", "HHD 500Gb", 15000, 10));
        catalogo.agregarComponente(new Componente("SSD 500GB", "SSD 500gb", 30000, 5));
        catalogo.agregarComponente(new Componente("SSD 1TB", "SSD 1 TB", 55000, 5));

        // Gráficas
        catalogo.agregarComponente(new Componente("Integrada", "No posse(integrada)", 0, 0));
        catalogo.agregarComponente(new Componente("GTX 1650", "GTX 1650", 90000, 75));
        catalogo.agregarComponente(new Componente("RTX 4090", "RTX 4090", 600000, 450));

        // Gabinetes
        catalogo.agregarComponente(new Componente("Gabinete Estandar", "Gabinete Estandar", 15000, 0));
        catalogo.agregarComponente(new Componente("Gabinete Intermedio", "Gabinete Intermedio", 25000, 0));
        catalogo.agregarComponente(new Componente("Gabinete Gamer", "Gabinete Gamer", 45000, 0));

        // Extras
        catalogo.agregarComponente(new Componente("Pad Termico", "pad termico", 2000, 0));
        catalogo.agregarComponente(new Componente("Cooler", "cooler", 8000, 10));
        catalogo.agregarComponente(new Componente("Fuente 800W", "Fuente 800W", 35000, 0));

        // Fuentes dinámicas para Gamer (consumo * 1.5)
        // Consumo Gamer: 125 + 5 + 5 + 5 + 5 + 450 + 0 + 0 + 10 = 605 -> 605 * 1.5 =
        // 907
        catalogo.agregarComponente(new Componente("Fuente 907W", "fuente 907 w", 45000, 0));

        // ============================
        // Armar PC Basica
        // ============================
        System.out.println("=== PC BASICA ===");
        ConfiguracionPC basica = new ConfiguracionBasica(catalogo);
        Equipo equipoBasico = basica.armarEquipo();
        System.out.println("Consumo: " + equipoBasico.getConsumo() + " W");
        System.out.println("Precio (con IVA): $" + equipoBasico.getPrecio());

        // ============================
        // Armar PC Intermedia
        // ============================
        System.out.println("\n=== PC INTERMEDIA ===");
        ConfiguracionPC intermedia = new ConfiguracionIntermedia(catalogo);
        Equipo equipoIntermedio = intermedia.armarEquipo();
        System.out.println("Consumo: " + equipoIntermedio.getConsumo() + " W");
        System.out.println("Precio (con IVA): $" + equipoIntermedio.getPrecio());

        // ============================
        // Armar PC Gamer
        // ============================
        System.out.println("\n=== PC GAMER ===");
        ConfiguracionPC gamer = new ConfiguracionGamer(catalogo);
        Equipo equipoGamer = gamer.armarEquipo();
        System.out.println("Consumo: " + equipoGamer.getConsumo() + " W");
        System.out.println("Precio (con IVA): $" + equipoGamer.getPrecio());
    }
}
