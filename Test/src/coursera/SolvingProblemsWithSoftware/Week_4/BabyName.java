package coursera.SolvingProblemsWithSoftware.Week_4;

import edu.duke.*;
import org.apache.commons.csv.*;

import java.io.File;

public class BabyName {

    public void printNames () {
        FileResource fr = new FileResource();
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            if (numBorn <= 100) {
                System.out.println("Name " + rec.get(0) +
                        " Gender " + rec.get(1) +
                        " Num Born " + rec.get(2));
            }
        }
    }

    int getRank(String year,String name,String gender){
        int nameRank=0;
        for (CSVRecord record:getCSVParser(year)){
            String recordGender=record.get(1);
            String recordName=record.get(0);
            if(recordGender.equalsIgnoreCase(gender)) {
                nameRank += 1;
                if(recordName.equalsIgnoreCase(name))
                    return nameRank;
            }
        }
        return -1;
    }

    String getName(String year,int rank,String gender){
        int nameRank=0;
        String name="";
        for (CSVRecord record:getCSVParser(year)){
            String recordGender=record.get(1);
            String recordName=record.get(0);

            if(recordGender.equalsIgnoreCase(gender)){
                nameRank+=1;
                if(nameRank == rank) {
                    name = recordName;
                    break;
                }
            }
        }
        return name.isEmpty()?"Not Found":name;
    }

    void whatIsNameInYear(String name,String year,String newYear,String gender){
        int yearRank=getRank(year,name,gender);
        String nameInNewYear="";
        if(yearRank != -1) {
            nameInNewYear = getName(newYear, yearRank, gender);
            System.out.println("Name  "+name+" in year "+year+" was rank "+yearRank+" so " +
                    "in new year "+newYear+" name is "+nameInNewYear);
        }
        else
            System.out.println("Name Not Present in year "+year);
    }

    int yearOfHighestRank(String name,String gender){
        DirectoryResource directoryResource=new DirectoryResource();
        int highestRank=100000;
        String year="";
        for(File file:directoryResource.selectedFiles()){
            int nameRankInFile=getRank(extractYearFromFileName(file.getName()),name,gender);
            if(nameRankInFile != -1 && nameRankInFile<highestRank) {
                highestRank = nameRankInFile;
                year=extractYearFromFileName(file.getName());
            }
        }

        return year.isEmpty()?-1:Integer.parseInt(year);
    }

    double getAverageRank(String name,String gender){
        DirectoryResource directoryResource=new DirectoryResource();
        int size=0;
        double total=0.0;
        for(File file:directoryResource.selectedFiles()) {
            int nameRankInFile = getRank(extractYearFromFileName(file.getName()), name, gender);
            if(nameRankInFile != -1){
                total+=nameRankInFile;
            }
            size+=1;
        }
        return total/size;
    }

    int getTotalBirthsRankedHigher(String year,String name,String gender){
        int total=0;

        for(CSVRecord record:getCSVParser(year)){
            String recordGender=record.get(1);
            String recordName=record.get(0);
            if(recordGender.equalsIgnoreCase(gender)){
                if(recordName.equalsIgnoreCase(name))
                    break;
                else
                    total+=Integer.parseInt(record.get(2));
            }
        }

        return total;
    }
    String extractYearFromFileName(String str){
        return str.substring(3,7);
    }
    CSVParser getCSVParser(String year){
        String fileName="us_babynames/us_babynames_test/";
        fileName+="yob"+year+"short.csv";
        return new FileResource(fileName).getCSVParser();
    }
    CSVParser getCSVParser(File file){
        return new FileResource(file).getCSVParser();
    }
    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        int girlsNames = 0;
        int boysNames=0;
        int totalNames=0;

        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
                boysNames+=1;
            }
            else {
                totalGirls += numBorn;
                girlsNames+=1;
            }
            totalNames+=1;
        }
        System.out.println("Total births = " + totalBirths);
        System.out.println("Total Names = "+totalNames);
        System.out.println("Female girls = " + totalGirls);
        System.out.println("Female Names = " + girlsNames);
        System.out.println("Male boys = " + totalBoys);
        System.out.println("Male Names = " + boysNames);


    }
    public void testGetRank(){
        System.out.println(getRank("2012","Mason","M"));
    }
    public void testIsWhatNameInYear(){
        whatIsNameInYear("Mason","2012","2014","M");
        whatIsNameInYear("Isabella","2012","2014","M");
    }
    public void testFindName(){
        System.out.println(getName("2012",2 ,"M"));
        System.out.println(getName("2014",2,"M"));
    }
    public void testTotalBirths () {
        //FileResource fr = new FileResource();
        FileResource fr = new FileResource("us_babynames/us_babynames_by_year/yob2014.csv");
        totalBirths(fr);
    }
    public void testHighestRank(){
        System.out.println(yearOfHighestRank("Mason","M"));
    }
    public void testAverageRank(){
        System.out.println(getAverageRank("Jacob","M"));
    }
    public void testGetTotalBirthsRankedHigher(){
        System.out.println(getTotalBirthsRankedHigher("2012","Ethan","M"));
    }
    public static void main(String[] args) {
        BabyName babyName=new BabyName();
        babyName.testGetTotalBirthsRankedHigher();
    }
}