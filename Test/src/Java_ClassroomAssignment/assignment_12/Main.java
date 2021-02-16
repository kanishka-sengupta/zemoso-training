package Java_ClassroomAssignment.assignment_12;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        StudentHolder studentHolder=new StudentHolder();
        InsertTestData.insertData(studentHolder);
        studentHolder.printAllDepartments();
        studentHolder.calculateAverageAgeOfGender();
    }
}
