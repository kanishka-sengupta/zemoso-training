package oops;
//Association Demo -> College Class Can Take in Teacher class but it doesnt depend on it.
import java.util.ArrayList;
import java.util.List;

class College{
    String name;
    private List<Teacher> teacherList;
    public College(String name, List<Teacher> teacher){
        this.name=name;
        this.teacherList=teacher;
    }

    public List<Teacher> getListOfTeachers(){
        return  teacherList;
    }
}
class Teacher{
    String name;
    String subject;

    public Teacher(String name,String subject){
        this.name=name;
        this.subject=subject;
    }

    @Override
    public String toString() {
        return "[ Teacher: "+this.name +", Subject: "+this.subject+"]";
    }
}
public class AgregationDemo {
    public static void main(String[] args) {
        List<Teacher> teachers= new ArrayList<Teacher>();
        teachers.add(new Teacher("Tumpa","Dance"));
        teachers.add(new Teacher("Jhumpa","Song"));

        College college=new College("Some Random",teachers);

        for (Teacher t:
             teachers) {
            System.out.println(t.toString());
        }
    }
}
