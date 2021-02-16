package coursera.SolvingProblemsWithSoftware.Week_2;

import java.util.ArrayList;
import java.util.HashMap;

class Part2{

    static int occurrences(String stringA,String stringB){
        int startPos=0;
        int occurrences=0;
        while(true){
            int foundIndex=stringB.indexOf(stringA,startPos);
            if(foundIndex == -1)
                break;
            occurrences++;
            startPos=foundIndex+stringA.length();
        }
        return occurrences;
    }

}


public class ImprovedGeneFinding {

    public int findStopCodon(String dna, int startIndex, String stopCodon){
        int currentIndex= dna.indexOf(stopCodon,startIndex+3);
        while (currentIndex != -1){
            int difference=currentIndex-startIndex;
            if(difference%3 == 0)
                return currentIndex;
            else
                currentIndex= dna.indexOf(stopCodon,currentIndex+3);
        }
        return -1;
    }

    String findGene(String dna){

        dna=dna.toLowerCase();
        int startIndex=dna.indexOf("atg");
        if(startIndex == -1)
            return "";
        int tgaIndex=findStopCodon(dna,startIndex,"tga");
        int taaIndex=findStopCodon(dna,startIndex,"taa");
        int tagIndex=findStopCodon(dna,startIndex,"tag");
        int minIndex;
        if(tgaIndex == -1 || (taaIndex != -1 && taaIndex<tgaIndex))
            minIndex=taaIndex;
        else
            minIndex=tgaIndex;

        if(minIndex == -1  || (tagIndex != -1 && tagIndex<minIndex))
            minIndex=tagIndex;

        if(minIndex == -1)
            return "";

        return dna.substring(startIndex,minIndex+3);
    }

    void printAllGenes(String dna){
        System.out.println("Printing all genes in dna: "+dna);
        String tempDna=dna;
        int startIndex=0;
        while(true){
           String gene=findGene(tempDna);
           if(gene.isEmpty())
               break;
           startIndex+=dna.indexOf(gene,startIndex)+gene.length();
           if(startIndex<tempDna.length())
                tempDna=dna.substring(startIndex);
           else
               tempDna="";
           System.out.println(gene);
        }
    }

    int countGenes(String dna){
        String tempDna=dna;
        int startIndex=0;
        int count=0;
        while(true){
            String gene=findGene(tempDna);
            if(gene.isEmpty())
                break;
            startIndex+=dna.indexOf(gene,startIndex)+gene.length();
            if(startIndex<tempDna.length())
                tempDna=dna.substring(startIndex);
            else
                tempDna="";
            count+=1;
        }
        return count;
    }


    public void testOccurrences(){
        HashMap<String,String> testStrings=new HashMap<String,String>();
        testStrings.put("an","Banana");
        testStrings.put("zoo","Forest");

        for (String stringA:testStrings.keySet()) {
            String stringB=testStrings.get(stringA);
            System.out.println("For "+stringB+" and "+stringA+" : "+Part2.occurrences(stringA,stringB));
        }
    }

    public void testCountGenes(){
        ArrayList<String> dnas=new ArrayList<String>();

        dnas.add("ATGTAAGATGCCCTAGT");

        for (String dna:dnas) {
            System.out.println("For DNA = "+dna+" number of genes are: "+countGenes(dna));
        }
    }

    public void testFindGene(){
        ArrayList<String> dnas=new ArrayList<String>();
        /*dnas.add("xxatgxxxtag");
        dnas.add("xxatgxxtaa");
        dnas.add("xxxyyyatgxxxyyyzzztga");
        dnas.add("xxxatgxxxyyyzzztagtgataa");
        dnas.add("xxxyyyzzz");
        dnas.add("xxxatgyyy");
        for (String dna:dnas) {
            String tempOutput=findGene(dna);
            System.out.println("DNA = "+dna);
            System.out.println("GENE = "+(tempOutput==""?"Not Found":tempOutput));
            System.out.println();
        }*/

        printAllGenes("atgtgaatgtaa");
    }
    public void testFindStopCodon(){
        ArrayList<String> dnas=new ArrayList<String>();
        dnas.add("xxxtga");
       // dnas.add("gagaggccaacattttttgaaatttttaagacacgctgcaacaaagcagatttaggacca");
       // dnas.add("ataagtcttaattggtttgaagaactttcttcagaagctccaccctataattctgaacct");

        for (String dna:dnas) {
            System.out.println("TAA = "+findStopCodon(dna,0,"taa"));
            System.out.println("TAG = "+findStopCodon(dna,0,"tag"));
            System.out.println("TGA = "+findStopCodon(dna,0,"tga"));
        }
    }

    public static void main(String[] args) {
        ImprovedGeneFinding improvedGeneFinding=new ImprovedGeneFinding();
        improvedGeneFinding.testCountGenes();
        improvedGeneFinding.printAllGenes("atgtaaatgttaatgtga");
    }
}
