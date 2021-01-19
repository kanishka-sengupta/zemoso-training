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

        Car car=new Car();
        car.run();

        Vehicle vehicle1=new Car();
        vehicle1.run();
    }
}
