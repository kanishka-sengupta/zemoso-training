package design_patterns.creational_patterns;

class Address{

    String street;
    String city;
    int roomNo;

    public Address(String street,String city, int roomNo){
        this.street=street;
        this.city=city;
        this.roomNo=roomNo;
    }

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", roomNo=" + roomNo +
                '}';
    }
}
class Contact implements Cloneable{
    public void setName(String name) {
        this.name = name;
    }
    public void setRoom(int roomNo) {
        this.address.roomNo=roomNo;
    }

    private String name;

    private Address address;

    public Contact(String name,Address address){
        this.name=name;
        this.address=address;
    }
    @Override
    public Object clone(){
        Object newObj=null;
        try{
            newObj=super.clone();
        }catch (CloneNotSupportedException exception){
            exception.printStackTrace();
        }
        return newObj;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", address=" + address +
                '}';
    }
}
class ContactFactory{
    static Contact mainOffice;
    static Contact backOffice;

    static{
        mainOffice=new Contact("",new Address("MG Road","Bangalore",12));
        backOffice=new Contact("",new Address("Hosur Road","Bangalore",57));
    }

    public static Contact newMainOfficeContact(String name,int roomNo){
        Contact newContact=(Contact) mainOffice.clone();
        newContact.setName(name);
        newContact.setRoom(roomNo);
        return newContact;
    }

    public static Contact newBackOfficeContact(String name,int roomNo){
        Contact newContact=(Contact) backOffice.clone();
        newContact.setName(name);
        newContact.setRoom(roomNo);
        return newContact;
    }
}
public class PrototypePattern {
    public static void main(String[] args) {
        Contact jane =ContactFactory.newMainOfficeContact("Jane",12);
        Contact doe=ContactFactory.newBackOfficeContact("Doe",59);
        System.out.println(jane);
        System.out.println(doe);

    }

    private static void NormalPrototype() {
        Contact john=new Contact("John", new Address("123","Kolkata",12));
        Contact doe=(Contact) john.clone();
        doe.setName("Doe");
        System.out.println(john);
        System.out.println(doe);
    }
}
