package coursera.SolvingProblemsWithSoftware.Week_2;

import java.util.ArrayList;

public class Part_1 {

    public String findSimpleGene(String dnaString){
        // Convert dnastring to lower case and store in separate variable for testing
        String testString=dnaString.toLowerCase();
        int start=testString.indexOf("atg");
        if(start == -1)
            return "";
        int end=testString.indexOf("taa",start+3);
        if(end == -1)
            return "";
        System.out.println(end+","+start);
        if((end-start)%3 == 0)
            return capitalize(dnaString.substring(start,end+3));
        else
            return "";
    }

    String capitalize(String str){
        if(str.startsWith("ATG")) // If the Gene Starts WITH ATG then all caps will return
            return str.toUpperCase();
        return str.toLowerCase();
    }

    public void testString(){
        ArrayList<String> dnaStrings=new ArrayList<String>();
        dnaStrings.add("TATGACTTaA");
        dnaStrings.add("ATGTTTTTTTAA");
        dnaStrings.add("gatgctataat");

        for (String dna:dnaStrings) {
            System.out.println("DNA = "+dna);
            System.out.println("Gene = "+findSimpleGene(dna));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Part_1 part_1=new Part_1();
        part_1.testString();
    }
}
