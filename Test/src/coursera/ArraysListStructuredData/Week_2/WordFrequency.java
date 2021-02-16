package coursera.ArraysListStructuredData.Week_2;

import edu.duke.FileResource;

import java.util.ArrayList;
import java.util.Locale;

public class WordFrequency {
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;

    public WordFrequency(){
        this.myWords=new ArrayList<String>();
        this.myFreqs=new ArrayList<Integer>();
    }

    void findUnique(){
        this.myWords.clear();
        this.myFreqs.clear();
        FileResource fileResource=new FileResource();
        for(String word:fileResource.words()){
            word=word.toLowerCase();
            int index=myWords.indexOf(word);
            if(index>=0)
                myFreqs.set(index,myFreqs.get(index)+1);
            else{
                myWords.add(word);
                myFreqs.add(1);
            }
        }
    }

    void tester(){
        findUnique();
        System.out.println("# unique words: "+myWords.size());
        int index = indexOfMax();
        System.out.println("max word/freq: "+myWords.get(index)+" "+myFreqs.get(index));

        for (int i = 0; i < myWords.size(); i++) {
            System.out.println(myWords.get(i)+" occurs "+myFreqs.get(i)+" times.");
        }
    }

    int indexOfMax(){
        int max=this.myFreqs.get(0);
        int maxIndex=0;

        for(int i=0;i<myFreqs.size();i++){
            int freq=myFreqs.get(i);
            if(freq > max){
                maxIndex=i;
                max=freq;
            }
        }

        return maxIndex;
    }

    public static void main(String[] args) {
        WordFrequency wordFrequency=new WordFrequency();
        wordFrequency.tester();
    }
}
