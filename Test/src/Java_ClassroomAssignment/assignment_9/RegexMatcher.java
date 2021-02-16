package Java_ClassroomAssignment.assignment_9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatcher {
    public static void main(String[] args) {
        System.out.print("Enter a string: ");
        Scanner scanner=new Scanner(System.in);
        String str= scanner.nextLine();
        //[A-Z] A to Z starting caps check
        //all small and caps and digits and white space accepted
        //Match last pattern until fullstops
        // use double escape character to terminate at fullstops
        Pattern pattern = Pattern.compile("[A-Z][a-zA-Z_0-9\s'\",]+\\.");
        Matcher matcher = pattern.matcher(str);
        System.out.println(matcher.matches());
    }
}
