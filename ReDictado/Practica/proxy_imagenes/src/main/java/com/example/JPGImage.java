package com.example;

public class JPGImage implements Image{
    private String uri;

    public JPGImage(String uri) {
        // Lógica costosa: descarga la imagen desde Internet
    } 
    public void displayOn(GraphicContext context) {
        // Lógica para mostrar la imagen en el GraphicContext
    }
    
    public Image scaleFor(GraphicContext context) {
        Image newImage = new JPGImage(this.uri);
        // Lógica para escalar la imagen
    
        return newImage;
    }
    
}
