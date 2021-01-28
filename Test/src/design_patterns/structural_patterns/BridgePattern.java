package design_patterns.structural_patterns;

interface Renderer{
    void render_circle(float x,float y,float radius);
}
class RasterRenderer implements Renderer{
    @Override
    public void render_circle(float x, float y, float radius) {
        System.out.println("Drawing a circle of radius "+radius+" at "+x+","+y);
    }
}
abstract class Shape{
    protected Renderer renderer;

    protected Shape(Renderer renderer){
        this.renderer=renderer;
    }

    abstract void draw();
    abstract void resize(float factor);
}

class Circle extends Shape{
    float x,y,radius;

    public Circle(Renderer r,float x,float y, float radius){
        super(r);
        this.x=x;
        this.y=y;
        this.radius=radius;
    }
    @Override
    void draw() {
        renderer.render_circle(x,y,radius);
    }

    @Override
    void resize(float factor) {
        radius*=factor;
    }
}
public class BridgePattern {
    public static void main(String[] args) {
        RasterRenderer r=new RasterRenderer();
        Circle circle=new Circle(r,2,2,5);
        circle.draw();
        circle.resize(5);
        circle.draw();
    }
}
