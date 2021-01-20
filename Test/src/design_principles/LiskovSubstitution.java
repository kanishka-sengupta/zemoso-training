package design_principles;
//Violation
class Rectangle {
    private double height;
    private double width;
    public void setHeight(double h) { height = h; }
    public void setWidth(double w) { width = w; }
}
class Square extends Rectangle {
    public void setHeight(double h) {
        super.setHeight(h);
        super.setWidth(h);
    }
    public void setWidth(double h) {
        super.setHeight(h);
        super.setWidth(h);
    }
}
public class LiskovSubstitution {
    public static void main(String[] args) {
        Rectangle r=new Rectangle();
        r.setHeight(10);
        r.setWidth(10);
        System.out.println();
        r=new Square();
    }
}
