package com.example;

public class ImageProxy implements Image {
    private String uri;
    private JPGImage realImage;

    public ImageProxy(String uri) {
        this.uri = uri;
        this.realImage = null; // Aún no se descarga la imagen
    }

    // Método auxiliar para la inicialización diferida (Lazy Loading)
    private void lazyLoad() {
        if (this.realImage == null) {
            this.realImage = new JPGImage(this.uri); // Se descarga solo al necesitarse
        }
    }

    public void displayOn(GraphicContext context) {
        lazyLoad();
        this.realImage.displayOn(context);
    }

    public Image scaleFor(GraphicContext context) {
        lazyLoad();
        return this.realImage.scaleFor(context);
    }
}
