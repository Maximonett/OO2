package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RepositorioAcademico {
    public Alumno buscarAlumno(String legajo) {

        // EN REALIDAD buscaria en BD
        return new Alumno("Juan Perez", legajo, "APU", "Regular");
    }

    public MateriaRendida[] buscarMateriaRendidas(String legajo) {
        // en realidad buscaria en la BD
        List<MateriaRendida> materias = new ArrayList<>();
        materias.add(new MateriaRendida("Matematica", LocalDate.of(2025, 11, 24), 8.0));
        materias.add(new MateriaRendida("CADP", LocalDate.of(2023, 6, 15), 8.0));
        return materias.toArray(new MateriaRendida[0]);
    }
}
