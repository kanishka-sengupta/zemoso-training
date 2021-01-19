package oops;

class House{
    private Kitchen kitchen;

    public House(){
        kitchen=new Kitchen();
        kitchen.setFood("Pizza");
    }
    public String getFood(){
        return kitchen.getFood();
    }
}
class Kitchen{
    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    private String food;
}
public class AssociationDemo {
    public static void main(String[] args) {
        House house=new House();
        System.out.println(house.getFood());
    }
}
