package Java_ClassroomAssignment.assigment_8;

import java.util.Scanner;

class UnderageError extends Exception{
    public UnderageError(String errorText){
        super(errorText);
    }
}
class EmptyNameError extends Exception{
    public EmptyNameError(String errorText){
        super(errorText);
    }
}
class OverweightError extends Exception{
    public OverweightError(String errorText){
        super(errorText);
    }
}


class TakeUserInputs{
    String name="";
    int age=0;
    double weight=0;
    Scanner scanner;
    TakeUserInputs(){
        scanner=new Scanner(System.in);
    }

    void takeName() throws EmptyNameError {
        System.out.print("Enter your name: ");
        name=scanner.nextLine();
        if(name.length() == 0)
            throw new EmptyNameError("Name cannot be empty.");
    }

    void takeAge() throws UnderageError {
        System.out.print("Enter your age: ");
        age=scanner.nextInt();
        if(age < 18)
            throw new UnderageError("You are underage");
    }

    void takeWeight() throws OverweightError{
        System.out.print("Enter your weight: ");
        weight=scanner.nextDouble();
        if(age < 18)
            throw new OverweightError("You are overweight");
    }
}
public class NewErrors {
    public static void main(String[] args) throws EmptyNameError {
        TakeUserInputs takeUserInputs=new TakeUserInputs();
        try{
            takeUserInputs.takeName();
            takeUserInputs.takeAge();
            takeUserInputs.takeWeight();
        }catch (OverweightError | UnderageError | EmptyNameError exception){
            System.out.println(exception.getMessage());
        }finally {
            System.out.println("Inside Finally");
        }
    }
}
