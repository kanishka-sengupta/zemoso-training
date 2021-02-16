package Java_ClassroomAssignment.assignment_7.CycleFactories;

public class Unicycle implements Cycle{
    private String colour;
    public static UnicycleFactory UnicycleFactory=new UnicycleFactory();
    public Unicycle(String colour){
        this.colour=colour;
    }
    @Override
    public void use() {
        System.out.println("Using "+this.colour+" Unicycle");
    }
}
