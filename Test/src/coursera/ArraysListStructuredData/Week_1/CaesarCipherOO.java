package coursera.ArraysListStructuredData.Week_1;

import edu.duke.FileResource;

class CaesarCipherNew{

    private String alphabets;
    private String shiftedAlphabets;
    private int key;

    public CaesarCipherNew(int key){
        this.key=key;
        this.alphabets="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.shiftedAlphabets=alphabets.substring(key) + alphabets.substring(0,key);
    }

    public String encrypt(String input){
        String tempInput=input.toUpperCase();
        StringBuilder stringBuilder=new StringBuilder();

        int index=0;
        for(char ch : tempInput.toCharArray()){
            int originalPos=alphabets.indexOf(ch);
            if(originalPos != -1) {
                char encryptedChar = alphabets.charAt(originalPos);
                char originalChar=input.charAt(index);
                stringBuilder.append(
                        (isCapital(originalChar))?
                                Character.toUpperCase(encryptedChar):
                                Character.toLowerCase(encryptedChar)
                );
            }else{
                stringBuilder.append(ch);
            }
            index+=1;
        }

        return stringBuilder.toString();
    }

    public String decrypt(String input){
        CaesarCipherNew caesarCipher=new CaesarCipherNew(26-key);
        return caesarCipher.encrypt(input);
    }

    Boolean isCapital(char ch){
        return Character.isUpperCase(ch);
    }
}

class TestCaesarCipherNew{
    void countLetters(String message,int frequency[]){
        String letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        message=message.toUpperCase();
        for(int i=0;i<message.length();i++){
            int letterPos=letters.indexOf(message.charAt(i));
            if(letterPos >= 0)
                frequency[letterPos]+=1;
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

    void simpleTestMethod(){
        FileResource fileResource=new FileResource();
        CaesarCipherNew caesarCipherNew=new CaesarCipherNew(3);
        String encrypted=caesarCipherNew.encrypt(fileResource.asString());
        System.out.println(caesarCipherNew.decrypt(encrypted));
    }
}
public class CaesarCipherOO {
    public static void main(String[] args) {
        TestCaesarCipherNew testCaesarCipherNew=new TestCaesarCipherNew();
        testCaesarCipherNew.simpleTestMethod();
    }
}
