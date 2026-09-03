package com.example;

public class Alumno {
    private String nombre;
    private String legajo;
    private String carrera;
    private String condicion;

    public Alumno(String nombre, String legajo, String carrera, String condicion) {
        this.nombre = nombre;
        this.legajo = legajo;
        this.carrera = carrera;
        this.condicion = condicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getLegajo() {
        return legajo;
    }

    public String getCarrera() {
        return carrera;
    }

    public String getCondicicon() {
        return condicion;
    }

}
