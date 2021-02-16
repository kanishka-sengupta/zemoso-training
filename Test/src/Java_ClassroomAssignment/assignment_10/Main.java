package Java_ClassroomAssignment.assignment_10;

public class Main {
    public static void main(String[] args) {
        SList<Integer> listOfInteger=new SList<Integer>();
        SListIterator listIterator=listOfInteger.iterator();

        listIterator.addLinkObject(10);
        listIterator.addLinkObject(20);
        listIterator.addLinkObject(30);
        listIterator.addLinkObject(40);
        listIterator.removeNodeObject();
        listIterator.addLinkObject(50);
        listIterator.removeNodeObject();
        listIterator.addLinkObject(10);

        System.out.println(listOfInteger.toString());

    }
}
