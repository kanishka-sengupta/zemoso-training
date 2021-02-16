package Java_ClassroomAssignment.assignment_7;


abstract class Cycle{
    void use(){
        System.out.println(this.getClass().getName().split("\\.")[2]);
    }
}
class Unicycle extends Cycle{
    void balance(){
        System.out.print("Have to balance ");
        super.use();
    }
}
class Bicycle extends Cycle{
    void balance(){
        System.out.print("Have to balance ");
        super.use();
    }
}
class Tricycle extends Cycle{}
public class UpcastDowncast {

    public static void main(String[] args) {
        Cycle cycle1,cycle2,cycle3;
        cycle1=new Unicycle();
        cycle2=new Bicycle();
        cycle3=new Tricycle();

        //cycle1.balance();
        Unicycle uni=(Unicycle) cycle1;
        uni.balance();

        Bicycle bi=(Bicycle) cycle2;
        bi.balance();
        cycle3.use();
    }
}
