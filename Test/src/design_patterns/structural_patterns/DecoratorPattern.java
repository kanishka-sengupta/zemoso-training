package design_patterns.structural_patterns;


interface IShape{
    String draw();
}
class Square implements IShape{

    private float sideLength;
    public Square(float sideLength){
        this.sideLength=sideLength;
    }
    void resize(float factor){
        sideLength*=factor;
    }
    public String draw() {
        return "A square of side length "+sideLength;
    }
}

class ColoredShape implements IShape{
    IShape shape;
    String color;

    public ColoredShape(IShape shape, String color){
        this.color=color;
        this.shape=shape;
    }

    @Override
    public String draw() {
        return shape.draw() + " has the color "+ color;
    }
}

class TransparentShape implements IShape {
    IShape shape;
    int transparency;

    public TransparentShape(IShape shape, int transparency){
        this.shape=shape;
        this.transparency=transparency;
    }

    @Override
    public String draw() {
        return shape.draw() + " has " +(float)((transparency/255.0f)*100.0f) + " % transparency";
    }
}
public class DecoratorPattern {
    public static void main(String[] args) {
        Square square=new Square(3);

        TransparentShape transparentShape=new TransparentShape(square,85);
        System.out.println(transparentShape.draw());
    }
}
