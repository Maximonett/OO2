package com.example;

public class ReTweet {
    private Usuario autor;
    private Tweet original;

    public ReTweet(){
        this.autor=autor;
        this.original=original;
    }

    public Tweet getOriginal(){
        return original;
    }

    public Usuario getAutor(){
        return autor;
    }

}
