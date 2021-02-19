package design_patterns.behavioural_patterns.strategy;

import java.util.Scanner;

public class PaymentGateway {
    private Scanner scanner;

    public PaymentGateway(){
        scanner=new Scanner(System.in);
    }

    public void takePayment(){
        double amount=0;
        int method=0;
        System.out.print("Enter amount to pay: ");
        amount=Double.parseDouble(scanner.nextLine());
        System.out.println("1. For PayTm wallet");
        System.out.println("2. For Debit Card");
        System.out.println("3. For UPI");
        System.out.print("Enter payment method: ");
        method=Integer.parseInt(scanner.nextLine());
        processPayment(getPaymentMethod(method),amount);
    }

    PaymentStrategy getPaymentMethod(int paymentIndex){
        switch (paymentIndex){
            case 1:
                return PaytmWallet.createNewPayment(scanner);
            case 2:
                return DebitCardStrategy.createNewPayment(scanner);
            case 3:
                return UPIStrategy.createNewPayment(scanner);
            default:
                System.out.println("Something went wrong");
                return null;
        }
    }

    public void processPayment(PaymentStrategy paymentStrategy, double amount){
        paymentStrategy.paySecurely(amount);
    }
}
