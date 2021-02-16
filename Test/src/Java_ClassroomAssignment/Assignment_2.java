package Java_ClassroomAssignment;

class ContainsAllLettersChecker{
    final static String allLetters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    //Space Complexity O(n)
    //Time Complexity O(n) in the first loop assuming indexOf takes constant time  we consider
    //indexOf searches the entire string of allLetters its O(n+26) + the last loop O(n)
    //which becomes O(2n + 26)
    //O(n) as factor 2 and constant term becomes insignificant
    static Boolean check(String input){
        input=input.toUpperCase();
        boolean[] seenChars=new boolean[allLetters.length()];
        for(char inputChar:input.toCharArray()){
            int index=allLetters.indexOf(inputChar);
            if(index>=0)
                seenChars[index]=true;
        }
        for(boolean seenChar:seenChars){
            if(!seenChar)
                return false;
        }
        return true;
    }

    static Boolean checkUsingStream(String input){
        long totalChars=input.toLowerCase().chars()//Create a Stream of Charcater Integers which we filter
                .filter(c-> c>='a' && c<='z')// for between a and z since we already converted it to lowercase
                .distinct().count();//count the distinct characters
        return totalChars==26;//compare with total characters 26
    }
}
public class Assignment_2 {
    public static void main(String[] args) {
        System.out.println(ContainsAllLettersChecker.check("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        System.out.println(ContainsAllLettersChecker.checkUsingStream("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));

        System.out.println(ContainsAllLettersChecker.check("ABCDEFGHIJKLMPQRSTUVWXYZ"));
        System.out.println(ContainsAllLettersChecker.checkUsingStream("ABCDEFGJKLMNOPQRSTUVWXYZ"));

        System.out.println(ContainsAllLettersChecker.check("ABCDEFGHIJKLMNOPQRSTUVWXYZaaabbbcc"));
        System.out.println(ContainsAllLettersChecker.checkUsingStream("ABCDEFGHIJKLMNOPQRSTUVWXYZccadwawq"));
    }
}
