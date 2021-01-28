package design_patterns.creational_patterns;

import java.util.HashMap;

interface HotDrink{
    void prepare(int volume);
}

class Tea implements HotDrink{
    public void prepare(int volume){
        System.out.println("Make Tea "+ volume);
    }
}

class Coffee implements HotDrink{
    public void prepare(int volume){
        System.out.println("Make Coffee " + volume);
    }
}

interface HotDrinkFactory{
    HotDrink make();
}

class CoffeeFactory implements HotDrinkFactory{

    @Override
    public HotDrink make() {
        return new Coffee();
    }
}

class TeaFactory implements  HotDrinkFactory{

    @Override
    public HotDrink make() {
        return new Tea();
    }
}
class DrinkFactory{
    HashMap<String,HotDrinkFactory> hotFactories=new HashMap<String,HotDrinkFactory>();

    DrinkFactory(){
        hotFactories.put("Coffee",new CoffeeFactory());
        hotFactories.put("Tea",new TeaFactory());
    }

    public HotDrink makeDrink(String name,int volume){
        HotDrink newDrink=hotFactories.get(name).make();
        newDrink.prepare(volume);
        return newDrink;
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        DrinkFactory drinkFactory=new DrinkFactory();
        HotDrink coffee=drinkFactory.makeDrink("Coffee",200);
        HotDrink tea=drinkFactory.makeDrink("Tea",100);
    }
}
