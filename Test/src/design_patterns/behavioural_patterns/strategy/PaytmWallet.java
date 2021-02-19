package design_patterns.behavioural_patterns.strategy;

import java.util.Scanner;

public class PaytmWallet implements PaymentStrategy{

    private String phoneNumber;

    public PaytmWallet(String number){
        this.phoneNumber=number;
    }

    @Override
    public void paySecurely(double amount) {
        System.out.println("Paid amount "+amount+" through paytm wallet linked to "+this.phoneNumber);
    }

    public static PaymentStrategy createNewPayment(Scanner scanner){
        String number="";
        System.out.print("Enter Phone Number linked to Paytm Wallet: ");
        number=scanner.nextLine();
        return new PaytmWallet(number);
    }
}
