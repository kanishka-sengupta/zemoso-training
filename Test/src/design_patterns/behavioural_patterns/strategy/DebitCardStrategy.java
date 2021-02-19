package design_patterns.behavioural_patterns.strategy;

import java.util.Scanner;

public class DebitCardStrategy implements PaymentStrategy{

    private String cardNumber;
    private int cvv;
    private String name;
    private String expiryDate;

    public DebitCardStrategy(String cardNumber,String name,String expiryDate,int cvv){
        this.cardNumber=cardNumber;
        this.name=name;
        this.expiryDate=expiryDate;
        this.cvv=cvv;
    }

    @Override
    public void paySecurely(double amount) {
        System.out.println("Paid amount "+amount+" through debit card ending with XX"+
                cardNumber.substring(cardNumber.length()-4));
    }

    public static PaymentStrategy createNewPayment(Scanner scanner){
        String name="";
        String cardNumber="";
        String expiryDate="";
        int cvv;
        System.out.print("Enter Debit Card Holder Name: ");
        name=scanner.nextLine();
        System.out.print("Enter Debit Card Number: ");
        cardNumber=scanner.nextLine();
        System.out.print("Enter Expiry Date: ");
        expiryDate=scanner.nextLine();
        System.out.print("Enter CVV :");
        cvv=Integer.parseInt(scanner.nextLine());
        return new DebitCardStrategy(cardNumber,name,expiryDate,cvv);
    }
}
