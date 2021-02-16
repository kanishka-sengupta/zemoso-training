package Java_ClassroomAssignment.assignment_10;

public class SList<T>{
    private Node<T> root;
    public SList(){
        this.root=new Node<T>();
    }

    @Override
    public String toString() {
        if(root.next==null)
            return "Empty";
        SListIterator iter = iterator();
        while(iter.next() != null){
            System.out.println(iter.toString());
        }
        return "Done";
    }

    SListIterator iterator(){
        return new SListIterator<T>(root);
    }
}
