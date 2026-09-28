package com.example;

public class Location {
    // 1. Atributos: Las coordenadas exactas de esta ubicación en el mapa
    private double x;
    private double y;

    // 2. Constructor: Para crear la ubicación pasándole sus coordenadas
    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // 3. Método distanceTo: Calcula la distancia exacta hasta otra ubicación
    public double distanceTo(Location otraUbicacion) {
        // Aplica la fórmula de distancia entre dos puntos (Teorema de Pitágoras)
        double diferenciaX = this.x - otraUbicacion.x;
        double diferenciaY = this.y - otraUbicacion.y;
        
        // Math.sqrt calcula la raíz cuadrada
        return Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY));
    }

    // 4. Método middle: Encuentra el punto intermedio entre esta ubicación y otra
    public Location middle(Location otraUbicacion) {
        // El punto medio se calcula sacando el promedio de las coordenadas
        double medioX = (this.x + otraUbicacion.x) / 2.0;
        double medioY = (this.y + otraUbicacion.y) / 2.0;
        
        // IMPORTANTE: Retorna un objeto Location NUEVO con esas coordenadas promedio
        return new Location(medioX, medioY);
    }
    
    // (Opcionalmente podrías agregar los métodos getters getX() y getY() si otra clase los necesitara)
}
