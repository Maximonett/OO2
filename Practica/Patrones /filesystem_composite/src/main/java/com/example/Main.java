package com.example;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // ===== Archivos =====
        Archivo a1 = new Archivo("a.txt", LocalDate.of(2024, 1, 10), 100);
        Archivo a2 = new Archivo("b.txt", LocalDate.of(2024, 2, 5), 500);
        Archivo a3 = new Archivo("c.txt", LocalDate.of(2024, 3, 1), 200);

        // ===== Directorios =====
        Directorio root = new Directorio("root", LocalDate.of(2024, 1, 1));
        Directorio docs = new Directorio("docs", LocalDate.of(2024, 1, 2));
        Directorio imgs = new Directorio("imgs", LocalDate.of(2024, 1, 3));

        // ===== Armar árbol =====
        docs.agregarElemento(a1);
        docs.agregarElemento(a2);

        imgs.agregarElemento(a3);

        root.agregarElemento(docs);
        root.agregarElemento(imgs);

        // ===== FileSystem =====
        FileSystem fs = new FileSystem(root);

        // ===== TESTS =====

        System.out.println("Tamaño total:");
        System.out.println(fs.tamanoTotalOcupado());

        System.out.println("\nArchivo más grande:");
        System.out.println(fs.archivoMasGrande().getNombre());

        System.out.println("\nArchivo más nuevo:");
        System.out.println(fs.archivoMasNuevo().getNombre());

        System.out.println("\nBuscar 'b.txt':");
        System.out.println(fs.buscar("b.txt").getNombre());

        System.out.println("\nBuscar todos 'a.txt':");
        List<Elemento> encontrados = fs.buscarTodos("a.txt");
        for (Elemento e : encontrados) {
            System.out.println(e.getNombre());
        }

        System.out.println("\nListado:");
        System.out.println(fs.listadoDeContenido());
    }
}