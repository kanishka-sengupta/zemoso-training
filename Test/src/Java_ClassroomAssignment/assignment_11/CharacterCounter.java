package Java_ClassroomAssignment.assignment_11;

import java.util.HashMap;

public class CharacterCounter {

    private HashMap<Character,Integer> characterCounts;
    private FileOperations fileOperations;

    public CharacterCounter(){
        this.characterCounts=new HashMap<Character,Integer>();
        fileOperations=new FileOperations();
    }

    public void ProcessFile(String fileName){
        String content=fileOperations.getFile(fileName);
        if(content == null)
            return;
        for(char character:content.toCharArray()){
            if(character == ' ' || character == '\t' || character == '\n')
                continue;
            int tempCounter=1;
            if(characterCounts.containsKey(character))
                tempCounter=characterCounts.get(character)+1;
            characterCounts.put(character,tempCounter);
        };
    }

    public void WriteHashmapToFile(){
        if(characterCounts.size() == 0)
            return;
        int status=fileOperations.WriteFile(characterCounts);
        if(status == 1)
            System.out.println("Successfully Wrote File");
        else
            System.out.println("Failed Check Strace");
    }
}
