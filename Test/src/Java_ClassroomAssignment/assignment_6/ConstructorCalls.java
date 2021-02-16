package Java_ClassroomAssignment.assignment_6;

class ClassA{
    ClassA(String arg){
        System.out.println(arg);
    }
}
public class ConstructorCalls {
    public static void main(String[] args) {
        ClassA classA[]=new ClassA[10];
        for (int i = 0; i < 10; i++) {
            classA[i]=new ClassA("I am Class "+(i+1));
        }
    }
}
