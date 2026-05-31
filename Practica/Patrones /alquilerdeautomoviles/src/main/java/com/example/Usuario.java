package com.example;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<AutoEnAlquiler> autosEnAlquiler;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.autosEnAlquiler = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<AutoEnAlquiler> getAutosEnAlquiler() {
        return autosEnAlquiler;
    }

    public void agregarAutoEnAlquiler(AutoEnAlquiler auto) {
        autosEnAlquiler.add(auto);
    }
}
