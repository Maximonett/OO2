package com.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Directorio extends Elemento {
    private List<Elemento> contenido;

    public Directorio(String nombre,LocalDate fechaCreacion){
        super(nombre,fechaCreacion);
        this.contenido=new ArrayList<Elemento>();
    } 

    @Override
    public int getTamanio(){
        return 32 + contenido.stream()
            .mapToInt(c ->c.getTamanio())
            .sum();
    }

    public void agregarElemento(Elemento elemento){
        contenido.add(elemento);
    }

    @Override
    public Archivo archivoMasGrande(){
        return contenido.stream()
            .map(e->e.archivoMasGrande())
            .max((archivo1,archivo2)->Integer.compare(archivo1.getTamanio(),archivo2.getTamanio()))
            .orElse(null);
    }
    @Override
    public Archivo archivoMasNuevo(){
        return contenido.stream()
            .map(e->e.archivoMasNuevo())
            .max((archivo1,archivo2)->archivo1.getFechaCreacion().compareTo(archivo2.getFechaCreacion()))
            .orElse(null);
    }
    @Override // busca en el directorio primero, sino , busca en el contenido (en los hijos hace la recursion)
    public Elemento buscar(String nombre){
        return this.compareName(nombre) ? this :    
            this.contenido.stream().map(elem->elem.buscar(nombre)) 
            .filter(elemento->elemento!=null).findFirst().orElse(null);
    }

    @Override 
    protected void buscarEnHijos(String nombre, List<Elemento> lista){
        this.contenido.stream()
            .forEach(elemento->elemento.buscarTodos(nombre,lista));
    }

    @Override
    public String listadoDeContenido(String prefijo){
        StringBuilder resultado=new StringBuilder();
        String pathActual=prefijo +this.getNombre();
        resultado.append(pathActual).append("\n");
        resultado.append(
            contenido.stream()
                .map(e->e.listadoDeContenido(pathActual + "/"))
                .collect(Collectors.joining())
        );
        return resultado.toString();
    } 



}
