package Java_ClassroomAssignment.assignment_7;

class Class_A{
    class Inner_1{
        Inner_1(String comment){
            System.out.println(comment);
            A();
        }
        void A(){
            System.out.println("Inside Inner 1");
        }
    }
}
class Class_B extends Class_A{
    public class Inner_2 extends Class_A.Inner_1 {
        Inner_2(){
            super("Calling Super");
        }
        @Override
        void A() {
            System.out.println("Inside B");
            super.A();
        }
    }
}
public class InnerClass {

    public static void main(String[] args) {
       Class_B class_b=new Class_B();
       Class_B.Inner_2 inner=class_b.new Inner_2();

    }
}
