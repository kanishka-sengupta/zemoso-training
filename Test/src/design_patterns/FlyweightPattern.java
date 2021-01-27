package design_patterns;

import java.util.HashMap;

class ConsoleColors{
    public static final String ANSI_RESET = "\u001B[0m";

    public static String getRandomColour(){
        return "\u001B["+ ((int)(Math.random()*10+30))+"m";
    }
}

interface Pen
{
    public void setColor(String color);
    public void draw(String content);
}
enum BrushSize {
    THIN, MEDIUM, THICK
}
class ThickPen implements Pen {

    final BrushSize brushSize = BrushSize.THICK;
    private String color = null;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing THICK content in color : " + color +" : "+content);
    }
}
class ThinPen implements Pen {

    final BrushSize brushSize = BrushSize.THIN;
    private String color = null;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing THIN content in color : " + color+" : "+content);
    }
}

class MediumPen implements Pen {

    final BrushSize brushSize = BrushSize.MEDIUM;
    private String color = null;

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public void draw(String content) {
        System.out.println("Drawing MEDIUM content in color : " + color +" : "+content);
    }
}
class PenFactory
{

    private static final HashMap<String, Pen> pensMap = new HashMap<>();

    public static Pen getThickPen(String color)
    {
        String key = color + "-THICK";
        Pen pen = pensMap.get(key);
        if(pen != null) {
            return pen;
        } else {
            pen = new ThickPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }

    public static Pen getThinPen(String color)
    {
        String key = color + "-THIN";
        Pen pen = pensMap.get(key);
        if(pen != null) {
            return pen;
        } else {
            pen = new ThinPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }

    public static Pen getMediumPen(String color)
    {
        String key = color + "-MEDIUM";
        Pen pen = pensMap.get(key);
        if(pen != null) {
            return pen;
        } else {
            pen = new MediumPen();
            pen.setColor(color);
            pensMap.put(key, pen);
        }
        return pen;
    }
}

public class FlyweightPattern {
    public static void main(String[] args) {
        Pen redThinPen1 = PenFactory.getThickPen("Red");
        redThinPen1.draw("Hello");

        Pen redThinPen2 = PenFactory.getThickPen("Red");
        redThinPen2.draw("World");

        Pen blueThinPen = PenFactory.getThickPen("Yellow");
        blueThinPen.draw("Hello World");

        System.out.println(redThinPen1.hashCode());
        System.out.println(redThinPen2.hashCode());
        System.out.println(blueThinPen.hashCode());

    }
}
