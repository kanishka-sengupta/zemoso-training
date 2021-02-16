package Java_ClassroomAssignment.assignment_7.CycleFactories;

public class TricycleFactory implements CycleFactory<Tricycle>{

    public Tricycle createNewCycle(String colour) {
        return new Tricycle(colour);
    }
}
