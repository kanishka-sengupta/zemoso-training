package design_principles;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

class Journal{
    public String title;
    public ArrayList<String> entries=new ArrayList<String>();


    public Journal(String title){
        this.title=title;
    }

    public void addEntry(String entry){
        entries.add(entry);
    }
}

class Persistence{
    public static void Save(Journal journal,String fileName){
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(journal.title+"\n");
            for (String entry:
                 journal.entries) {
                writer.write(entry+"\n");
            }
            writer.close();
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }
}
public class SingleResponsibility {
    public static void main(String[] args) {
        Journal j=new Journal("Dear Diary");
        j.addEntry("Ate too much.");
        j.addEntry("Slept too much.");
        Persistence.Save(j,"Journal.txt");
    }
}
