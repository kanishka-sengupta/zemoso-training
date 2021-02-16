package coursera.ArraysListStructuredData.Week_1;

import edu.duke.FileResource;

import java.util.Arrays;

public class WordLength {


    void countWordLengths(String message, int counts[]){
        String words[]=message.split("\\W+");
        for(Object word:words){
            String tempWord=word.toString();
            counts[tempWord.length()]+=1;
        }
    }

    int indexOfMax(int counts[]){
        int maxPos=0;
        for(int i=0;i<counts.length;i++){
            if(counts[i]>counts[maxPos]){
                maxPos=i;
            }
        }
        return maxPos;
    }
    void testCountWords(){
        FileResource fileResource=new FileResource();
        int counts[]=new int[31];
        countWordLengths(fileResource.asString(),counts);
        for(int i =2;i<counts.length;i++){
            System.out.println(i+" letter words are "+counts[i]);
        }

        System.out.println(indexOfMax(counts));
    }

    public static void main(String[] args) {
        WordLength wordLength=new WordLength();
        wordLength.testCountWords();
    }
}
