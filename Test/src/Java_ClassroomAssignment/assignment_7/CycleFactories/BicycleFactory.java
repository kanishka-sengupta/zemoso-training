package Java_ClassroomAssignment.assignment_7.CycleFactories;

public class BicycleFactory implements CycleFactory<Bicycle>{

    public Bicycle createNewCycle(String colour) {
        return new Bicycle(colour);
    }
}
