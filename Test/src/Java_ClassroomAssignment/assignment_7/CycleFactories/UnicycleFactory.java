package Java_ClassroomAssignment.assignment_7.CycleFactories;

public class UnicycleFactory implements CycleFactory<Unicycle>{

    public Unicycle createNewCycle(String colour) {
        return new Unicycle(colour);
    }
}
