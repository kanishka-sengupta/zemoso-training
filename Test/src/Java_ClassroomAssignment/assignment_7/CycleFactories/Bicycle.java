package Java_ClassroomAssignment.assignment_7.CycleFactories;

public class Bicycle implements Cycle{
    private String colour;
    public static BicycleFactory BicycleFactory=new BicycleFactory();
    public Bicycle(String colour){
        this.colour=colour;
    }
    @Override
    public void use() {
        System.out.println("Using "+this.colour+" Bicycle");
    }
}
