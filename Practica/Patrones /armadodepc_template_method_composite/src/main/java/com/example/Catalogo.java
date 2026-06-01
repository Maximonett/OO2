package com.example;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Componente> componentes;

    public Catalogo() {
        this.componentes = new ArrayList<>();
    }

    public Componente getComponente(String descripcion) {
        return componentes.stream()
                .filter(c -> c.getDescripcion().equals(descripcion))
                .findFirst()
                .orElse(null);
    }

    public void agregarComponente(Componente componente) {
        componentes.add(componente);
    }
}
