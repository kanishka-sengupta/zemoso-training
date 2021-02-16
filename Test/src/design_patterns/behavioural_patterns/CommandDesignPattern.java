package design_patterns.behavioural_patterns;

class Account{
    private String name;
    private double balance;

    Account(String name,double balance){
        this.name=name;
        this.balance=balance;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}

class AccountCommandHandler{
    private Account account;
    AccountCommandHandler(Account account){
        this.account=account;
    }
    public void processCommand(AccountCommand command){
        command.execute(this.account);
    }
}
interface AccountCommand{
    void execute(Account account);
}
class DepositCommand implements AccountCommand{
    double amount;
    DepositCommand(double amount){
        this.amount=amount;
    }
    public void execute(Account account) {
        account.setBalance(
                account.getBalance()+amount
        );
    }
}
class WithdrawCommand implements AccountCommand{
    double amount;
    WithdrawCommand(double amount){
        this.amount=amount;
    }
    public void execute(Account account) {
        double balanceAfterDeduction=account.getBalance()-amount;
        if(balanceAfterDeduction>=0)
            account.setBalance(balanceAfterDeduction);
        else
            System.out.println("Insufficient Funds");
    }
}

class TestCommands{
    Account account;
    AccountCommandHandler accountCommandHandler;
    TestCommands(){
        account=new Account("Raze",1000);
        accountCommandHandler=new AccountCommandHandler(account);
    }

    public void testDepositCommand(){
        DepositCommand depositCommand=new DepositCommand(23456);
        System.out.println(account);
        accountCommandHandler.processCommand(depositCommand);
        System.out.println("New Balance:"+account.getBalance());
        System.out.println();
    }

    public void testWithdrawErrorCommand(){
        WithdrawCommand withdrawCommand=new WithdrawCommand(100000);
        System.out.println("Withdrawing: "+withdrawCommand.amount);
        accountCommandHandler.processCommand(withdrawCommand);
        System.out.println(account);
        System.out.println();
    }

    public void testWithdrawCommand(){
        WithdrawCommand withdrawCommand=new WithdrawCommand(2500);
        System.out.println("Withdrawing: "+withdrawCommand.amount);
        accountCommandHandler.processCommand(withdrawCommand);
        System.out.println(account);
        System.out.println();
    }
}

public class CommandDesignPattern {
    public static void main(String[] args) {
        TestCommands testCommands=new TestCommands();
        testCommands.testDepositCommand();
        testCommands.testWithdrawCommand();
        testCommands.testWithdrawErrorCommand();
    }
}
