package design_patterns.creational_patterns;


class Point{
    private double x,y;
    protected Point(double x,double y){
        this.x=x;
        this.y=y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
class PointFactory{
    public static Point NewCartesian(double x,double y){
        return new Point(x,y);
    }
    public static Point NewPolar(double r,double theta){
        return new Point(r*Math.cos(theta),r*Math.sin(theta));
    }
}
public class FactoryPattern {
    public static void main(String[] args) {
        Point p=PointFactory.NewCartesian(5,10);
        Point p2=PointFactory.NewPolar(5,0.5);
        System.out.println(p);
        System.out.println(p2);
    }
}
