package coursera.ArraysListStructuredData.Week_1;

import edu.duke.FileResource;

public class CaesarCipher {

    String encrypt(String input,int key){
        StringBuilder stringBuilder=new StringBuilder();
        String letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String tempInput=input.toUpperCase();
        String encryptionLetters=letters.substring(key) + letters.substring(0,key);

        int index=0;
        for(char ch : tempInput.toCharArray()){
            int originalPos=letters.indexOf(ch);
            if(originalPos != -1) {
                char encryptedChar = encryptionLetters.charAt(originalPos);
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

    String encryptTwoKeys(String input,int key1,int key2){
        StringBuilder stringBuilder=new StringBuilder();
        String letters="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String tempInput=input.toUpperCase();
        String encryptionLettersSetOne=letters.substring(key1) + letters.substring(0,key1);
        String encryptionLettersSetTwo=letters.substring(key2) + letters.substring(0,key2);

        for(int i=0;i<tempInput.length();i++){
            char originalChar=tempInput.charAt(i);
            int originalPos=letters.indexOf(originalChar);
            if(originalPos != -1) {
                char encryptedChar = (i % 2 == 0) ? encryptionLettersSetOne.charAt(originalPos)
                        : encryptionLettersSetTwo.charAt(originalPos);

                stringBuilder.append(
                        (isCapital(input.charAt(i))) ?
                                Character.toUpperCase(encryptedChar) :
                                Character.toLowerCase(encryptedChar)
                );
            }else{
                stringBuilder.append(originalChar);
            }
        }

        return stringBuilder.toString();
    }

    Boolean isCapital(char ch){
        return Character.isUpperCase(ch);
    }
    void testCaesar(){
        int key=23;
        FileResource fr = new FileResource();
        String message = fr.asString();
        String encrypted = encrypt(message, key);
        System.out.println("key is " + key + "\n" + encrypted);
    }

    void testPQ(){
        String str="At noon be in the conference room with your hat on for a surprise party. YELL LOUD!";
        System.out.println(encrypt(str,15));
    }

    void testTwoEncrypt(){
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21) );
    }

}
