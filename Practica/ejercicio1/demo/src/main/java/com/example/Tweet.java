package com.example;

public class Tweet {
    private Usuario autor;
    private Mensaje contenido;

    private Tweet original;

    public Tweet(Usuario autor,Mensaje contenido){
        this.autor=autor;
        this.contenido=contenido;
    }

    
    public Tweet(Tweet original, Usuario autor){
        this.original=original;
        this.autor=autor;
    }


}
