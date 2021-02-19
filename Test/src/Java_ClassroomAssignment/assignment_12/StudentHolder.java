package Java_ClassroomAssignment.assignment_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    public void calculateAveragePercentage(){
        Map<String,List<Student>> students=studentOperations.GROUP_BY_DEPARTMENT(allStudents);
        for(String str:students.keySet()){
            System.out.print("Average % in "+str+" ");
            System.out.println(studentOperations.CALCULATE_AVERAGE_PER_OF(students.get(str)));
        }
    }
    public void howManyGender(List<Student> allStudents){
        List<Student> maleStudents=studentOperations.FILTER_BY_GENDER("MALE",allStudents);
        List<Student> femaleStudents=studentOperations.FILTER_BY_GENDER("FEMALE",allStudents);
        System.out.println("Total "+allStudents.size());
        System.out.println("\tMale "+maleStudents.size());
        System.out.println("\tFemale "+femaleStudents.size());
    }
    public void enrolledAfter(int year){
        List<Student> enrolledAfter=studentOperations.ENROLLED_AFTER_YEAR(year,allStudents);
        printStudents(enrolledAfter);
    }
    public void getStudentsOf(String course){
        Map<String,List<Student>> students=studentOperations.GROUP_BY_DEPARTMENT(allStudents);
        printStudents(students.get(course));
    }
    public void getStudentsOf(String course,String gender){
        Map<String,List<Student>> students=studentOperations.GROUP_BY_DEPARTMENT(allStudents);
        List<Student> maleCourseStudent=studentOperations.FILTER_BY_GENDER(gender,students.get(course));
        printStudents(maleCourseStudent);
    }
    public void getGenderSizeOf(String course){
        Map<String,List<Student>> students=studentOperations.GROUP_BY_DEPARTMENT(allStudents);
        System.out.println(course);
        howManyGender(students.get(course));
    }
    public void getGenderSizeOf(){
        System.out.println("All Departments");
        howManyGender(this.allStudents);
    }
    void printStudents(List<Student> students){
        for(Student student: students){
            System.out.println(student.toString());
        }
    }

}
