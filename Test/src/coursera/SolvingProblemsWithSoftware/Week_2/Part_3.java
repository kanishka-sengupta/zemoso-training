package coursera.SolvingProblemsWithSoftware.Week_2;

import java.util.HashMap;

public class Part_3 {

    Boolean twoOccurrences(String stringA, String stringB){
        int startPos=0;
        int occurrences=0;
        while(true){
            int foundIndex=stringB.indexOf(stringA,startPos);
            if(foundIndex == -1)
                break;
            occurrences++;
            startPos=foundIndex+stringA.length();
            System.out.println(foundIndex);
        }
        return occurrences>=2;
    }

    String lastPart(String stringA,String stringB){
        int index=stringB.indexOf(stringA);
        if(index == -1)
            return stringB;
        return stringB.substring(index+stringA.length());
    }
    void testing(){
        HashMap<String,String> testStrings=new HashMap<String,String>();
        testStrings.put("an","Banana");
        testStrings.put("zoo","Forest");
        for (String stringA:testStrings.keySet()) {
            String stringB=testStrings.get(stringA);
            System.out.println("For "+stringB+" and "+stringA+" : "+lastPart(stringA,stringB));
            //System.out.println("For "+stringB+" and "+key+" : "+twoOccurrences(stringA,stringB));
        }
    }

    public static void main(String[] args) {
        Part_3 part_3=new Part_3();
        part_3.testing();
    }
}
