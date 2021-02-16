package Java_ClassroomAssignment.assignment_10;

import java.util.Iterator;

public class SListIterator<T> implements Iterator {

    private Node currentLink;
    private Node rootLink;

    public SListIterator(Node root) {
        rootLink=root;
        currentLink=root;
    }
    //Will Add to the end of the list
    public void addLinkObject(T obj){
        Node<T> temp=new Node<T>(currentLink.next,obj);
        currentLink.next=temp;
        currentLink=currentLink.next;
    }
    //Will remove from the start
    public void removeNodeObject(){
        Node temp=currentLink;
        currentLink=rootLink;
        if(hasNext()){
            currentLink.next=currentLink.next.next;
        }
        currentLink=temp;
    }

    @Override
    public boolean hasNext() {
        return currentLink.next != null;
    }

    @Override
    public Node next() {
        if(hasNext()){
            currentLink=currentLink.next;
            return currentLink;
        }else
            return null;
    }

    @Override
    public String toString() {
        return currentLink.toString();
    }
}
