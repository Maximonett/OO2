package com.example;

public interface SandwichBuilder {
    void reset();
    void buildPan();
    void buildAderezo();
    void buildPrincipal();
    void buildAdicional();
    Sandwich getSandwich();
}
