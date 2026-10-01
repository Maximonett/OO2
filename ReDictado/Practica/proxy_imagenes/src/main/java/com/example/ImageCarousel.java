package com.example;

import java.util.ArrayList;
import java.util.List;

public class ImageCarousel {
    private Integer imageIdx = 0;
    private GraphicContext panel;
    private List<Image> images = new ArrayList<>();

    public void addImage(String uri) {
        // Solución: Solo se guarda el Proxy con el URI, no hay descarga en este punto.
        images.add(new ImageProxy(uri));
    }
}
