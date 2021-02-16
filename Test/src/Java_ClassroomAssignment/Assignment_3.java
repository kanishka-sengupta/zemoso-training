package Java_ClassroomAssignment;

import java.io.IOException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

class PingMedianCalculator{

    private int numberOfPings;
    private String hostName;
    private Scanner inputScanner;
    private Double[] allResults;

    public PingMedianCalculator(){
        this.numberOfPings=0;
        this.hostName="";
        inputScanner=new Scanner(System.in);
    }

    void takeInput(){
        System.out.print("Enter the hostname: ");
        hostName=inputScanner.nextLine();
        System.out.print("Enter the number of pings: ");
        numberOfPings=inputScanner.nextInt();
    }

    public void processPingCommand() throws IOException, InterruptedException {
        if(this.numberOfPings<=0){
            System.out.println("Number Of Pings cant be 0 or less");
            return;
        }
        String command = "ping -c "+this.numberOfPings+" "+this.hostName;
        Process process = Runtime.getRuntime().exec(command);
        Scanner resultScanner=new Scanner(process.getInputStream());
        Scanner errorScanner=new Scanner(process.getErrorStream());
        //Check if result scanner is empty or not if yes that means we caused an error
        Scanner temp=resultScanner.hasNext()?resultScanner:errorScanner;
        readProcessOutput(temp);
        process.waitFor();
    }

    private void readProcessOutput(Scanner typeOfScanner){
        String line = "";
        int tempResultCounter=this.numberOfPings;
        allResults=new Double[this.numberOfPings];
        while(line != null) {
            String sub=line.substring(line.lastIndexOf('=')+1);
            System.out.print(sub+"\n");
            if(tempResultCounter>0 && sub.contains("ms")){
                allResults[tempResultCounter-1]=Double.parseDouble(sub.substring(
                        0,sub.indexOf(" ms")));
                tempResultCounter--;
            }
            try{
                line=typeOfScanner.nextLine();
            }catch (NoSuchElementException exception){
                line=null;
            }
        }
    }

    public Double medianValue() {
        if(allResults.length == 0)
            return -1.0;
        SortArrayResults();
        if (this.numberOfPings % 2 == 0){// Int Division works fine since it automatically converts to ArrayIndexVal
            int indexOne = (this.numberOfPings - 1) / 2;
            int indexTwo = (this.numberOfPings + 1) / 2;
            return (this.allResults[indexOne]+this.allResults[indexTwo])/2;
        }
        else{
            //Odd Integer division it will be be to the lowest int anyway
            return this.allResults[(this.numberOfPings/2)];
        }
    }

    private void SortArrayResults(){
        allResults=Arrays.copyOf(Arrays.stream(allResults)
                .sorted().toArray(),this.numberOfPings,Double[].class);
    }

    public void tester(){
        takeInput();
        try {
            processPingCommand();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Median is "+medianValue());
        for (int i = 0; i < this.numberOfPings; i++) {
            System.out.println(allResults[i]);
        }
    }
}
public class Assignment_3 {
    public static void main(String[] args) {
        PingMedianCalculator pingMedianCalculator=new PingMedianCalculator();
        pingMedianCalculator.tester();
    }
}
