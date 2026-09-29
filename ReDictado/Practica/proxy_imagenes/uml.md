````mermaid
classDiagram
    class Image {
        <<Interface>>
        +displayOn(:GraphicContext) void
        +scaleFor(:GraphicContext) Image
    }
    
    class JPGImage {
        +displayOn(:GraphicContext) void
        +scaleFor(:GraphicContext) Image
    }
    
    class ImageProxy {
        -uri : String
        -realImage : JPGImage
        +ImageProxy(uri : String)
        +displayOn(:GraphicContext) void
        +scaleFor(:GraphicContext) Image
    }
    
    class ImageCarousel {
        -imageIdx : Integer = 0
        -panel : GraphicContext
        +ImageCarousel(:GraphicContext, :Image[])
        +addImage(:URI) void
        +displayLastImage() void
        +displayNextImage() void
    }

    JPGImage ..|> Image
    ImageProxy ..|> Image
    ImageProxy o--> "0..1" JPGImage : -realImage
    ImageCarousel o--> "2..n" Image : -images

```