package Java_ClassroomAssignment.assignment_7;

import java.util.Random;

abstract class Rodent{
    public String species;

    public abstract void eat();
    public void walk(){
        System.out.println(species+" going on a walk");
    }
    public void sleep(){
        System.out.println(species+" going to sleep");
    }
}

class Mouse extends Rodent{
    Mouse(){
        String temp=this.getClass().getName();
        this.species=temp.substring(temp.lastIndexOf('.')+1);
        System.out.println("Hi I am a "+this.species);
    }
    public void eat() {
        System.out.println(this.species+" snacking on veggies");
    }
}

class Hamster extends Rodent{
    Hamster(){
        String temp=this.getClass().getName();
        this.species=temp.substring(temp.lastIndexOf('.')+1);
        System.out.println("Hi I am a "+this.species);
    }
    public void eat() {
        System.out.println(this.species+" snacking on shredded chicken");
    }
}

class Gerbil extends Rodent{
    Gerbil(){
        String temp=this.getClass().getName();
        this.species=temp.substring(temp.lastIndexOf('.')+1);
        System.out.println("Hi I am a "+this.species);
    }
    public void eat() {
        System.out.println(this.species+" snacking on worms");
    }
}

public class Assignment_7 {
    public static void main(String[] args) {
        Rodent allRodents[]=new Rodent[10];
        for (int i = 0; i <10; i++) {
            Random random=new Random();
            int num= random.nextInt(3);
            switch (num){
                case 0->{
                    allRodents[i]=new Mouse();
                }
                case 1->{
                    allRodents[i]=new Hamster();
                }
                case 2->{
                    allRodents[i]=new Gerbil();
                }
            }
        }
        for (int i = 0; i <10; i++) {
            allRodents[i].eat();
            allRodents[i].walk();
            allRodents[i].sleep();
        }

    }
}
