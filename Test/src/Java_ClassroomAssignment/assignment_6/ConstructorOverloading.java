package Java_ClassroomAssignment.assignment_6;

public class ConstructorOverloading {
    ConstructorOverloading(int x){
        this(x,x*x);
        System.out.println("First Constructor "+x);
    }
    ConstructorOverloading(int x,int y){
        System.out.println("Second Constructor "+x+" "+y);
    }

    public static void main(String[] args) {
        ConstructorOverloading constructorOverloading=new ConstructorOverloading(2);
    }
}
