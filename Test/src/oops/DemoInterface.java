package oops;

public interface DemoInterface {
    public void m1();
    public int m2();
    static void m3(){};
    default int m4(){ return 0; };
    private void m5(){
        System.out.println();
    }
}
abstract class AbstractInterface implements DemoInterface{
    @Override
    public void m1() {
        System.out.println("Implements Abstract");
    }
}

class Implementation extends AbstractInterface{
    @Override
    public int m2() {
        return 0;
    }
}
