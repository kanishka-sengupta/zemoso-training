package Java_ClassroomAssignment.assignment_5.singleton;

public class Singleton {
    private String string;

    //Static methods cannot access non-static variables since static methods are part of the class
    //Not the instance of the class. Static var/methods are loaded once in the memory during the class
    // compilation. They have been loaded into the memory when the Class was initialized.
    //We can't access 'this' keyword either because this refers to the current instance of the class
    //And static class has no idea about any instance since they below to the Class and not the instance.

    /*public static Singleton init(String input){
        this.string=input;
        return this;
    }*/

    public void print(){
        System.out.println("Print "+this.string);
    }
}
