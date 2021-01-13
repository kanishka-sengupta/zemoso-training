package com.company;

class Fan{
    private  boolean isOn;// Instance Variable
    public static String companyName;// Static Variable (One Copy available to all instances)
    Fan(){// Default Constructor
        companyName="BS";
    }
    Fan(String companyName){//Parameterised Constructor
        this.companyName=companyName;
    }
    void turnOn(){
        int localVar=5;//Only available to this function = Local Variable
        isOn=true;
        System.out.println("Fan On!");
    }
    void turnOff(){
        isOn=false;
        System.out.println("Fan Off");
    }
}
public class Main {

    public static void main(String[] args) {

        System.out.println("Hello World");
        Fan f=new Fan();

        f.turnOn();
        f.turnOff();
    }
}
interface Bicycle{
    void changeGear(int newValue);
}
class MountainBike implements Bicycle{
    public void changeGear(int newValue){

    }
}
