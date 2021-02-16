package coursera.ArraysListStructuredData.Week_1;

public class WordPlay {

    Boolean isVowel(char ch){
        char vowels[]={'a','e','i','o','u'};
        for (char vowel:vowels){
            if(vowel==Character.toLowerCase(ch))
                return true;
        }
        return false;
    }

    String replaceVowels(String phrase,char character){
        StringBuilder stringBuilder=new StringBuilder(phrase);
        for (int i=0;i<phrase.length();i++){
            if(isVowel(stringBuilder.charAt(i)))
                stringBuilder.setCharAt(i,character);
        }
        return  stringBuilder.toString();
    }

    String emphasize(String phrase, char ch){
        StringBuilder stringBuilder=new StringBuilder(phrase);
        for(int i=0;i<phrase.length();i++){
            if(stringBuilder.charAt(i) == ch){
                int numberIndex=i+1;
                stringBuilder.setCharAt(i,(numberIndex%2)==0?'+':'*');
            }
        }
        return stringBuilder.toString();
    }

    void testIsVowel(){
        System.out.println(isVowel('A'));
    }
    void testReplaceVowel(){
        System.out.println(replaceVowels("Hippie Sabotage",'*'));
    }
    void testEmphasize(){
        System.out.println(emphasize("Banana is in the freezer!!", 'i'));
        System.out.println(emphasize("dna ctgaaactga", 'a'));
    }

    public static void main(String[] args) {
        WordPlay wordPlay=new WordPlay();
        wordPlay.testIsVowel();
        wordPlay.testEmphasize();
        wordPlay.testReplaceVowel();
    }
}
