package coursera.ArraysListStructuredData.Week_2;

import edu.duke.FileResource;

import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characterNames;
    private ArrayList<Integer> characterCounts;

    public CharactersInPlay(){
        this.characterNames=new ArrayList<String>();
        this.characterCounts=new ArrayList<Integer>();
    }

    void update(String character){
        int indexOfCharacter=this.characterNames.indexOf(character);
        if(indexOfCharacter>=0)
            this.characterCounts.set(indexOfCharacter,this.characterCounts.get(indexOfCharacter)+1);
        else{
            this.characterNames.add(character);
            this.characterCounts.add(1);
        }
    }

    void findAllCharacters(){
        FileResource fileResource=new FileResource();
        for(String line: fileResource.lines()){
            int period=line.indexOf('.');
            if(period>0)
                update(line.substring(0,period).trim());
        }
    }

    void charactersWithNumParts(int num1,int num2){
        for (int i = 0; i < characterNames.size(); i++) {
            int count=characterCounts.get(i);
            if(num1<=count && count<=num2)
                System.out.println("Name: "+characterNames.get(i)+" appeared "+count+ " times.");
        }
    }

    void tester(){
        findAllCharacters();
        for (int i = 0; i < characterNames.size(); i++) {
            int count=characterCounts.get(i);
            if(count>1)
                System.out.println("Name: "+characterNames.get(i)+" appeared "+count+ " times.");
        }
        //charactersWithNumParts(10,15);
    }

    public static void main(String[] args) {
        CharactersInPlay charactersInPlay=new CharactersInPlay();
        charactersInPlay.tester();
    }
}
