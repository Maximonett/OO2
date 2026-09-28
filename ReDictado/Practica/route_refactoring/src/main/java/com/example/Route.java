package com.example;

public class Route {
    private Location[] waitPoints;
    private int currentIdx;

    // ... (constructor y otros métodos)

    // 1. Extraemos el comportamiento repetido a un método privado
    private double calculateDistance(int startIndex, String param) {
        double res = 0;
        for (int i = startIndex; i < waitPoints.length; i++) {
            if (param.equals("Linear")) {
                res += waitPoints[i].distanceTo(waitPoints[i-1]);
            } else {
                res += (waitPoints[i].middle(waitPoints[i-1])).distanceTo(waitPoints[i-1]);
            }
        }
        return res;
    }

    // 2. Simplificamos los métodos públicos para que deleguen en el privado
    public double fullDistance(String param) {
        return calculateDistance(1, param);
    }

    public double distanceLeft(String param) {
        return calculateDistance(currentIdx + 1, param);
    }

    // El método next() queda igual porque no tenía código repetido
    public Location next() {
        return currentIdx < waitPoints.length ? waitPoints[currentIdx++] 
            : waitPoints[waitPoints.length - 1];
    }
}
