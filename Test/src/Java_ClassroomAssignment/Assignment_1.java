package Java_ClassroomAssignment;

import java.io.File;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Scanner;

class SearchHomeDirectory{
    void takeInput() throws IOException, InterruptedException {
        Scanner scanner=new Scanner(System.in);
        while(true){
            System.out.print("Enter a pattern to search: ");
            String input=scanner.nextLine();
            if(input.equalsIgnoreCase("q!"))
                break;
            searchHomeDirectory(input);
        }
    }
    void searchHomeDirectory(String pattern) throws IOException, InterruptedException {
        String command = "find /home -name "+pattern;
        Process process = Runtime.getRuntime().exec(command);
        Scanner reader=new Scanner(process.getInputStream());
        String line = "";
        while(line != null) {
            if(new File(line).isFile())
                System.out.print(line + "\n");
            try{
                line=reader.nextLine();
            }catch (NoSuchElementException exception){
                line=null;
            }
        }
        process.waitFor();
    }
}
public class Assignment_1 {
    public static void main(String[] args) {
        SearchHomeDirectory searchHomeDirectory=new SearchHomeDirectory();
        try{
            searchHomeDirectory.takeInput();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
