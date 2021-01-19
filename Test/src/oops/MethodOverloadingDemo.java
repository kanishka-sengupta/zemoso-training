package oops;

class Add{
    public int sum(int a,int b){
        return a+b;
    }
    public int sum(int a,int b,int c){
        return a+b+c;
    }
    public double sum(double a,double b){
        return a+b;
    }
}
public class MethodOverloadingDemo {
    public static void main(String[] args) {
        Add add=new Add();
        System.out.println(add.sum(10,14));
        System.out.println(add.sum(10,12,12));
        System.out.println(add.sum(10.10f,202.2)); // float,double went into double,double

        // byte -> short -> int -> long -> float -> double
        //                   ||
        //                  char
    }
}
