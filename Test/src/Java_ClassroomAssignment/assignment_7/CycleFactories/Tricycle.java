package Java_ClassroomAssignment.assignment_7.CycleFactories;

public class Tricycle implements Cycle{
    private String colour;
    public static TricycleFactory TricycleFactory=new TricycleFactory();
    public Tricycle(String colour){
        this.colour=colour;
    }
    @Override
    public void use() {
        System.out.println("Using "+this.colour+" Tricycle");
    }
}
