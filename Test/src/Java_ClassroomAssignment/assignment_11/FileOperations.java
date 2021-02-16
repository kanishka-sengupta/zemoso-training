package Java_ClassroomAssignment.assignment_11;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class FileOperations {
    private String fileName="";
    public String getFile(String fileName){
        if(fileName.length()==0)
            return null;
        FileReader reader = null;
        String fileContent="";
        this.fileName=fileName;
        try {
            reader=new FileReader(fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(reader == null)
            return null;
        while(true){
            try {
                int ch= reader.read();
                if (ch == -1) break;
                fileContent+=(char)ch;
                System.out.println(fileContent);

            } catch (IOException | NullPointerException e) {
                System.out.println(e.getMessage());
            }

        }
        return fileContent;
    }

    public int WriteFile(HashMap<Character,Integer> allCounts){
        try {
            FileWriter fileWriter=new FileWriter(this.fileName.split("\\.")[0]+"_CharacterCount.txt");
            for(Character character:allCounts.keySet()){
                String writeString=character+" : "+allCounts.get(character);
                fileWriter.write(writeString+"\n");
            }
            fileWriter.close();
            return 1;
        } catch (IOException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
