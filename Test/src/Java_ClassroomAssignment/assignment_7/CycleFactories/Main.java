package Java_ClassroomAssignment.assignment_7.CycleFactories;

public class Main {
    public static void main(String[] args) {
        Unicycle unicycle=Unicycle.UnicycleFactory.createNewCycle("Red");
        unicycle.use();

        Bicycle bicycle=Bicycle.BicycleFactory.createNewCycle("Blue");
        bicycle.use();

        Tricycle tricycle=Tricycle.TricycleFactory.createNewCycle("Green");
        tricycle.use();
    }
}
