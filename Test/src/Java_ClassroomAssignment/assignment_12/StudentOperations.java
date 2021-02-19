package Java_ClassroomAssignment.assignment_12;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class StudentOperations {
    public List<Student> ENROLLED_AFTER_YEAR(int year,List<Student> allStudents){
        return allStudents.stream().filter(student -> student.getYear()>=year)
                .collect(Collectors.toList());
    }
    public List<Student> FILTER_BY_GENDER(String gender,List<Student> allStudents){
        return allStudents.stream().filter(student -> student.getGender().equalsIgnoreCase(gender))
                .collect(Collectors.toList());
    }
    public Map<String,List<Student>> GROUP_BY_DEPARTMENT(List<Student> allStudents){
        return allStudents.stream().collect(Collectors.groupingBy(Student::getDepartment));
    }
    public double CALCULATE_AVERAGE_OF(List<Student> allStudents){
        return allStudents.stream().mapToDouble(Student::getAge).average().getAsDouble();
    }
    public double CALCULATE_AVERAGE_PER_OF(List<Student> allStudents){
        return allStudents.stream().mapToDouble(Student::getPerTillDate).average().getAsDouble();
    }

}
