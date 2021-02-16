package Java_ClassroomAssignment.assignment_5.data;

public class DataClass {
    private int someInt;
    private char someChar;

    //Default Constructor initializes the member variables to default values
    //Local variables dont get that treatment and thats why they are never initialized and throws an error
    public void print() {
        System.out.println("DataClass{" +
                "someInt=" + someInt +
                ", someChar=" + someChar +
                '}');
    }

    /*public void printLocalVariable(){
        int num;
        char character;
        System.out.println("DataClass{" +
                "someInt=" + num +
                ", someChar=" + character +
                '}');
    }*/
}
