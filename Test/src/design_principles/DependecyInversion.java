package design_principles;
interface IEngineInterface{
    void start();
}
class PetrolEngine implements IEngineInterface{
    public void start(){
        System.out.println("Petrol Burning");
    }
}
class DieselEngine implements IEngineInterface{
    public void start(){
        System.out.println("Diesel Burning");
    }
}
class Car{
    private IEngineInterface engine;

    public Car(IEngineInterface engine){
        this.engine=engine;
    }

    public void start(){
        engine.start();
    }
}
public class DependecyInversion {
    public static void main(String[] args) {
        PetrolEngine petrol=new PetrolEngine();
        DieselEngine dieselEngine=new DieselEngine();
        Car car=new Car(petrol);

    }
}
