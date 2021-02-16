package coursera.ArraysListStructuredData.Week_2;

import java.util.Comparator;
import java.util.HashMap;

public class CodonCount {
    private HashMap<String,Integer> codonCounts;

    public CodonCount(){
        this.codonCounts=new HashMap<String,Integer>();
    }

    void buildCodonMap(int start,String dna){
        this.codonCounts.clear();
        dna=dna.substring(start);
        int lastStartIndex=0;
        for (int i = 0; i <= dna.length(); i++) {
            if(i>0 && i % 3 == 0){
                updateMap(dna.substring(lastStartIndex,i));
                lastStartIndex=i;
            }
        }
    }

    void updateMap(String codon){
        int val=1;
        if(codonCounts.containsKey(codon)){
            val=codonCounts.get(codon) + val;
        }
        codonCounts.put(codon,val);
    }

    String getMostCommonCodon(){
        int max=0;
        String maxKey="";
        for(String key: codonCounts.keySet()){
            int val=codonCounts.get(key);
            if(val > max){
                max=val;
                maxKey=key;
            }
        }
        return maxKey;
    }

    void printCodonCounts(int start,int end){
        for (String keys: codonCounts.keySet()) {
            int val=codonCounts.get(keys);
            if(val >= start && val <= end) {
                System.out.println(
                        "Codon : " + keys + " appeared " + codonCounts.get(keys)
                );
            }
        }
        System.out.println();
    }

    void tester(){
        String dna="CGTTCAAGTTCAA";
        buildCodonMap(0,dna);
        printCodonCounts(2,3);
        System.out.println(getMostCommonCodon());
        buildCodonMap(1,dna);
        buildCodonMap(2,dna);
    }

    public static void main(String[] args) {
        CodonCount codonCount=new CodonCount();
        codonCount.tester();
    }

}
