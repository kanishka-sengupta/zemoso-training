package Java_ClassroomAssignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Assignment_4 {
    public static void main(String[] args) throws ParseException {
        Scanner scanner=new Scanner(System.in);
        Scanner scanner1=new Scanner(System.in);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
        System.out.print("Enter number of dates: ");
        int counter=scanner.nextInt();
        String output="";
        while (counter > 0) {
            String str = scanner1.nextLine();
            String str2 = scanner1.nextLine();
            Date date1 = simpleDateFormat.parse(str);
            Date date2 = simpleDateFormat.parse(str2);
            counter--;
            if(date1.compareTo(date2)>0){
                output+="Not Applicable\n";
                continue;
            }
            Calendar c = Calendar.getInstance();
            c.setTime(date2);
            int year = c.get(Calendar.YEAR);
            c.setTime(date1);
            c.set(Calendar.YEAR, year);
            Date temp = c.getTime();
            c.add(Calendar.DAY_OF_MONTH, -30);
            Date lowerBound = c.getTime();
            c.setTime(temp);
            c.add(Calendar.DAY_OF_MONTH, 30);
            Date upperBound = c.getTime();
            if(date2.compareTo(lowerBound) >= 0 && date2.compareTo(upperBound) <= 0){
                output+=simpleDateFormat.format(lowerBound)+" ";
                output+=simpleDateFormat.format(date2);
                output+="\n";
            }else{
                output+=simpleDateFormat.format(lowerBound);
                output+=simpleDateFormat.format(upperBound);
                output+="\n";
            }
        }
        System.out.println(output);
    }
}
