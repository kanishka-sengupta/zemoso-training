package design_patterns.structural_patterns;

import java.util.ArrayList;

interface IItem{
    String name();
    IPacking packing();
    float price();
}

interface IPacking{
    String pack();
}

class Wrapper implements IPacking{
    @Override
    public String pack(){
        return "Wrapper";
    }
}

class Bottle implements  IPacking{
    @Override
    public String pack() {
        return "Bottle";
    }
}

abstract class Burger implements IItem{
    @Override
    public IPacking packing(){
        return new Wrapper();
    }

    @Override
    public abstract float price();
}

abstract class ColdDrink implements IItem{
    @Override
    public IPacking packing(){
        return new Bottle();
    }

    @Override
    public abstract float price();
}

class VegBurger extends Burger{
    @Override
    public String name() {
        return "Veg Burger";
    }

    @Override
    public float price() {
        return 45;
    }
}

class ChickenBurger extends Burger{
    @Override
    public String name() {
        return "Chicken Burger";
    }

    @Override
    public float price() {
        return 65;
    }
}

class Coke extends ColdDrink{
    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 20;
    }
}
class PaperBoat extends ColdDrink{
    @Override
    public String name() {
        return "PaperBoat";
    }

    @Override
    public float price() {
        return 10;
    }
}

class  Meal{
    private ArrayList<IItem> items=new ArrayList<IItem>();

    public Meal addItem(IItem item){
        items.add(item);
        return this;
    }

    public float getCost(){
        float totalCost=0;
        for (IItem i:
             items) {
            totalCost+=i.price();
        }
        return totalCost;
    }

    public void showItems(){
        for (IItem i:
             items) {
            System.out.print("Item: " + i.name());
            System.out.print("  Packing: " + i.packing().pack());
            System.out.println("  Price: " + i.price());
        }
    }
}

class MealBuilder{
    public Meal NonVegMeal(){
        Meal meal=new Meal();
        meal.addItem(new ChickenBurger()).addItem(new ChickenBurger()).addItem(new Coke());
        return meal;
    }
}
public class CompositeBuilder {
    public static void main(String[] args) {
        MealBuilder builder=new MealBuilder();
        Meal nonvegMeal=builder.NonVegMeal();
        nonvegMeal.showItems();
        System.out.println("Total Cost: "+nonvegMeal.getCost());
    }
}