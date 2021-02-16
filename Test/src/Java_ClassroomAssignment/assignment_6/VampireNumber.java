package Java_ClassroomAssignment.assignment_6;

import java.util.Arrays;
import java.util.HashMap;


public class VampireNumber {

    public void PrintVampireNumber(int range){
        String[] str1, str2;
        int pro, sum = 0;
        for (int i = 10; i < 1000; i++) {
            for (int j = i; j < 1000; j++) {
                pro = i * j;
                int lengthi = String.valueOf(i).length();
                int lengthj = String.valueOf(j).length();
                if (pro < 1000 || pro > 999999 || lengthi != lengthj)
                    continue;
                str1 = String.valueOf(pro).split("");
                str2 = (String.valueOf(i) + String.valueOf(j)).split("");
                Arrays.sort(str1);
                Arrays.sort(str2);
                if (Arrays.equals(str1, str2)) {
                    sum++;
                    System.out.println(i + "*" + j + "=" + pro);
                    if(sum == range)
                        break;
                }
            }
        }
    }
    public static void main(String[] args) {
        VampireNumber vampireNumber=new VampireNumber();
        vampireNumber.PrintVampireNumber(100);
    }
}
