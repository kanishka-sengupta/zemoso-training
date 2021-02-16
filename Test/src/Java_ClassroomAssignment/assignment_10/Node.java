package Java_ClassroomAssignment.assignment_10;

public class Node<T>{
    public T val;
    public Node next;

    /**
     *
     * @param next
     * @param val
     */
    public Node(Node next, T val){
        this.next=next;
        this.val=val;
    }
    public Node(){
        this.next=null;
        this.val=null;
    }

    @Override
    public String toString() {
        if(val == null)
            return "Null";
        return val.toString();
    }
}
