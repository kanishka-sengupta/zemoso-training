package oops;
// Encapsulation = Abstraction + Data Hiding
class Account {
    public double getBalance() {// Abstraction since we dont know
                                // what this function implements but we know what this returns
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance = 10000; //Data Hiding
}
public class EncapsulationDemo {
    public static void main(String[] args) {
        Account myAcc=new Account();
        myAcc.setBalance(1000.00);
        System.out.println(myAcc.getBalance());
    }
}
