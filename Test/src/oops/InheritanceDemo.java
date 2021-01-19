package oops;
//Single Level
//Parent
class A{

}
//Child
class B extends  A{

}
//Multilevel
class C extends  B{

}
//Multiple
interface  AA{
    default void printSomething(){
        System.out.println("Inside AA!");
    }
}
interface  BB{
    default void printSomething(){
        System.out.println("Inside BB!");
    }
}
class Multilevel implements  AA,BB{
    @Override
    public void printSomething() {
        BB.super.printSomething(); //How to call function of same name from the interface we implemented.
        //System.out.println("INside M");
    }
}
//Hierarchical Inheritance
class Hierarchical extends A implements  AA,BB{ // A is a single parent and has multiple children B,Hierarchical
    @Override
    public void printSomething() {

    }
}
public class InheritanceDemo {
    public static void main(String[] args) {
        Multilevel m=new Multilevel();
        m.printSomething();
    }
}
