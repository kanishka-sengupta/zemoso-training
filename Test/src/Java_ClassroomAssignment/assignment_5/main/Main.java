package Java_ClassroomAssignment.assignment_5.main;

import Java_ClassroomAssignment.assignment_5.data.DataClass;
import Java_ClassroomAssignment.assignment_5.singleton.Singleton;

public class Main {
    public static void main(String[] args) {
        DataClass dataClass=new DataClass();
        dataClass.print();
        //dataClass.printLocalVariable();

        Singleton singleton=new Singleton();
        singleton.print();
    }
}
