package oops;

class BankAccount{
    private double balance = 10000;
    private String username = "tadao";
    private String password = "password";

    public double getWalletBalance(String username,String password){
        if(this.username.equals(username) && this.password.equals(password)){
            return  balance;
        }else{
            return -1.0;
        }
    }
}
public class AccessAccount {
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount();
        System.out.println(
                "My balance is "+
                myAccount.getWalletBalance("tadao","password")
                +"$"
        );
    }
}
