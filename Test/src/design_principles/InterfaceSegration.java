package design_principles;


interface IPrinter{
    void print();
}
interface IScanner{
    void scan();
}
interface IFaxer{
    void fax();
}

interface IMachine extends IPrinter,IScanner,IFaxer{

}

class Machine implements IMachine{
    public void print(){
        System.out.println("Printing");
    }
    public void scan(){
        System.out.println("Scanning");
    }
    public void fax(){
        System.out.println("Faxing");
    }
}
public class InterfaceSegration {
}
