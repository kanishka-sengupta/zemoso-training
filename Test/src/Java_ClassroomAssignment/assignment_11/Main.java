package Java_ClassroomAssignment.assignment_11;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter fileName: ");
        String fileName=scanner.nextLine();
        CharacterCounter wordCounter=new CharacterCounter();
        wordCounter.ProcessFile(fileName);
        wordCounter.WriteHashmapToFile();
    }
}
