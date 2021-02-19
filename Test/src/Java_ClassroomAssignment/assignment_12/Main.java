package Java_ClassroomAssignment.assignment_12;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentHolder studentHolder=new StudentHolder();
        InsertTestData.insertData(studentHolder);
        studentHolder.printAllDepartments();
        System.out.println();
        studentHolder.enrolledAfter(2018);
        System.out.println();
        studentHolder.getStudentsOf("Computer Science");
        System.out.println();
        studentHolder.getStudentsOf("Computer Science","Male");
        studentHolder.getGenderSizeOf("Computer Science");
        System.out.println();
        studentHolder.getGenderSizeOf();
        studentHolder.calculateAveragePercentage();
    }
}
