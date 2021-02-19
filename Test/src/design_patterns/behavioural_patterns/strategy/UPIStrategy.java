package design_patterns.behavioural_patterns.strategy;

import java.util.Scanner;

public class UPIStrategy implements PaymentStrategy{

    private String upiID;

    public UPIStrategy(String upiID){
        this.upiID=upiID;
    }

    @Override
    public void paySecurely(double amount) {
        System.out.println("Paid amount "+amount+" through UPI ID "+this.upiID);
    }

    public static PaymentStrategy createNewPayment(Scanner scanner){
        String upiID="";
        System.out.print("Enter UPI ID: ");
        upiID= scanner.nextLine();
        return new UPIStrategy(upiID);
    }
}
