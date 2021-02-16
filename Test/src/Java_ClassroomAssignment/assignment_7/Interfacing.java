package Java_ClassroomAssignment.assignment_7;

interface interfaceA{
    void method_A();
    void method_B();
}
interface interfaceB{
    void method_C();
    void method_D();
}
interface interfaceC{
    void method_E();
    void method_F();
}
interface interfaceD extends interfaceA, interfaceB, interfaceC {
    void method_G();
}
class ClassB{
    public void method_A(){
        System.out.println("Inside Class B");
    }
}
class ClassA extends ClassB  implements interfaceD{

    @Override
    public void method_A() {
        System.out.println("Inside Method A");
    }

    @Override
    public void method_B() {
        System.out.println("Inside Method B");
    }

    @Override
    public void method_C() {
        System.out.println("Inside Method C");
    }

    @Override
    public void method_D() {
        System.out.println("Inside Method D");
    }

    @Override
    public void method_E() {
        System.out.println("Inside Method E");
    }

    @Override
    public void method_F() {
        System.out.println("Inside Method F");
    }

    @Override
    public void method_G() {
        System.out.println("Inside Method G");
    }
}

class TestClass{
    static void printInterfaceA(interfaceA inter){
        inter.method_A();
        inter.method_B();
    }
    static void printInterfaceB(interfaceB inter){
        inter.method_C();
        inter.method_D();
    }
    static void printInterfaceC(interfaceC inter){
        inter.method_E();
        inter.method_F();
    }
    static void printInterfaceD(interfaceD inter){
        inter.method_G();
        inter.method_A();
    }
}
public class Interfacing {
    public static void main(String[] args) {
        ClassA classA=new ClassA();
        TestClass.printInterfaceA(classA);
        TestClass.printInterfaceD(classA);
    }
}
