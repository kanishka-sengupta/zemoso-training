package coursera.ArraysListStructuredData.Week_1;

import edu.duke.FileResource;

public class CaesarBreaker{
    public String decrypt(String encrypted){
        CaesarCipher caesarCipher=new CaesarCipher();
        int frequency[]=new int[26];
        int key=0;
        //Calculate the number of unique letters in encrypted string
        //Most used english letter is 'E'
        countLetters(encrypted,frequency);
        int indexOfMax=indexOfMax(frequency);
        //We subtract the max used letter index with the value of 4(pos of E)
        key=indexOfMax-4;
        if(indexOfMax < 4)
            key=26-(4-indexOfMax);
        return caesarCipher.encrypt(encrypted,26-key);
    }

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

    String halfOfString(String message, int start){
        String str="";
        for(int i=start;i<message.length();i+=2)
            str+=message.charAt(i);
        return str;
    }

    int getKey(String message){
        int frequency[]=new int[26];
        countLetters(message,frequency);
        int indexOfMax=indexOfMax(frequency);
        int key=indexOfMax-4;
        if(indexOfMax < 4)
            key=26-(4-indexOfMax);
        return key;
    }

    String decryptTwoKeys(String message){
        String messageA=halfOfString(message,0);
        String messageB=halfOfString(message,1);
        int keyA=getKey(messageA);
        int keyB=getKey(messageB);

        System.out.println(keyA+","+keyB);

        return new CaesarCipher().encryptTwoKeys(message,26-keyA,26-keyB);
    }

    void testDecrypt(){
        CaesarCipher caesarCipher=new CaesarCipher();
        String encrypted=caesarCipher.encrypt("Hello How Are you? Are",3);
        System.out.println(encrypted);
        //encrypted=caesarCipher.encrypt(encrypted,23);
        encrypted=decrypt("Top ncmy qkff vi vguv vbg ycpx");
        System.out.println(encrypted);
    }

    void testTwoDecrypt(){
        CaesarCipher caesarCipher=new CaesarCipher();
        String encrypted=caesarCipher.encryptTwoKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque vel tristique dolor. Pellentesque iaculis venenatis orci id pellentesque. Suspendisse lectus neque, posuere in congue eget, commodo in nulla. Ut posuere gravida nisl eu iaculis. Quisque maximus metus nec vulputate pellentesque. Sed tincidunt lacinia nulla eu egestas. Fusce vulputate augue in eros mollis hendrerit. Sed tortor elit, porttitor ac dui et, finibus laoreet ipsum. Nam vitae erat ipsum. Nunc accumsan ornare vehicula. Donec sed semper sem, in vehicula massa.",3,6);
        System.out.println(encrypted);
        encrypted=decryptTwoKeys("Top ncmy qkff vi vguv vbg ycpx");
        System.out.println(encrypted);
    }

    public static void main(String[] args) {
        CaesarBreaker caesarBreaker=new CaesarBreaker();
        caesarBreaker.testDecrypt();
    }
}
