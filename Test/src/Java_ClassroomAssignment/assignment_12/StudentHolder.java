package Java_ClassroomAssignment.assignment_12;

import java.util.ArrayList;
import java.util.List;

public class StudentHolder {
    private ArrayList<Student> allStudents=new ArrayList<Student>();
    private StudentOperations studentOperations;

    StudentHolder(){
        studentOperations=new StudentOperations();
    }

    public void addStudent(Student student){
        allStudents.add(student);
    }
    public void addStudent(Student[] students){
        for (Student student:students) {
            addStudent(student);
        }
        System.out.println(allStudents.size());
    }

    public void printAllDepartments(){
        for(String str:studentOperations.GROUP_BY_DEPARTMENT(allStudents).keySet()){
            System.out.println(str);
        }
    }
    public void calculateAverageAgeOfGender(){
        List<Student> maleStudents=studentOperations.FILTER_BY_GENDER("MALE",allStudents);
        List<Student> femaleStudents=studentOperations.FILTER_BY_GENDER("FEMALE",allStudents);
        System.out.println(studentOperations.CALCULATE_AVERAGE_OF(maleStudents));
        System.out.println(studentOperations.CALCULATE_AVERAGE_OF(femaleStudents));
    }
    public void howManyGender(){
        List<Student> maleStudents=studentOperations.FILTER_BY_GENDER("MALE",allStudents);
        List<Student> femaleStudents=studentOperations.FILTER_BY_GENDER("FEMALE",allStudents);
        System.out.println("Male "+maleStudents.size());
        System.out.println("Female "+femaleStudents.size());
    }
    public void enrolledAfter(int year){
        List<Student> enrolledAfter=studentOperations.ENROLLED_AFTER_YEAR(year,allStudents);

    }

}
