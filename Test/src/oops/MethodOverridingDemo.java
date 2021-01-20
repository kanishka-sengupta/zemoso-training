package oops;

class Vehicle{
    public void run(){
        System.out.println("Vehicle is Running");
    }
}
class  Car extends Vehicle{
    public void run(){
        System.out.println("Car is running");
    }
}
public class MethodOverridingDemo {
    public static void main(String[] args) {
        Vehicle vehicle=new Vehicle();
        vehicle.run();
        DemoInterface demo=new DemoInterface() {
            @Override
            public void m1() {

            }

            @Override
            public int m2() {
                return 0;
            }
        };
        Car car=new Car();
        car.run();

        Vehicle vehicle1=new Car();
        vehicle1.run();
    }
}
