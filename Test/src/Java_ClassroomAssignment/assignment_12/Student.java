package Java_ClassroomAssignment.assignment_12;

public class Student {
    private int id,age,year;
    private  String name;
    private String gender;
    private String department;

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDepartment() {
        return department;
    }

    public double getPerTillDate() {
        return perTillDate;
    }

    private double perTillDate;
    public Student(int id, String name, int age, String gender, String department, int year, double perTillData) {
        this.id=id;
        this.name=name;
        this.age=age;
        this.gender=gender;
        this.department=department;
        this.year=year;
        this.perTillDate=perTillData;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", year=" + year +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", department='" + department + '\'' +
                ", perTillDate=" + perTillDate +
                '}';
    }
}
