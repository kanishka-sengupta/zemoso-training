package design_patterns.behavioural_patterns.strategy;

public class Main {
    public static void main(String[] args) {
        PaymentGateway paymentMachine=new PaymentGateway();
        paymentMachine.takePayment();
    }
}
