package oops;

import java.util.ArrayList;

interface Mobile{
    public void calling(String number);
    public void sendMessage(String message);
}
class Apple implements Mobile{
    private ArrayList<String> contacts = new ArrayList<String>();
    @Override
    public void calling(String number) {
        System.out.println("Calling..."+number);
    }

    @Override
    public void sendMessage(String message) {
        System.out.println("Sending message..."+message);
    }
    public void addContact(String number){
        contacts.add(number);
        var array=contacts.toArray();
        for (int i = 0; i < contacts.stream().count(); i++) {
            System.out.println(array[i]);
        }
    }
}
public class AbstractionDemo {

    public static void main(String[] args) {
        Apple newPhone=new Apple();
        newPhone.calling("9689657925");
        newPhone.sendMessage("Hey new phone who dis?");
        newPhone.addContact("8889741562");

        Samsung notTerrible = new Samsung();
        notTerrible.calling("9689657925");
        notTerrible.sendMessage("Mary Jane says Hi");
        notTerrible.addContact("8889741562");


    }
}

abstract class mobilee{
    private ArrayList<String> contacts = new ArrayList<String>();

    abstract void calling(String number);
    abstract void sendMessage(String message);

    public void addContact(String number){
        contacts.add(number);
        var array=contacts.toArray();
        for (int i = 0; i < contacts.stream().count(); i++) {
            System.out.println(array[i]);
        }
    }
}
class Samsung extends mobilee{
    @Override
    void calling(String number) {
        System.out.println("Samsung Calling..."+number);
    }

    @Override
    void sendMessage(String message) {
        System.out.println("Samsung Sending message..."+message);
    }
}
