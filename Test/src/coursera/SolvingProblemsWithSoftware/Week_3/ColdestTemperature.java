package coursera.SolvingProblemsWithSoftware.Week_3;

import edu.duke.DirectoryResource;
import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.File;

public class ColdestTemperature {

    CSVRecord coldestHourInFile(CSVParser parser){
        CSVRecord coldestRecord=null;
        for(CSVRecord currentRecord : parser){
            if(coldestRecord == null)
                coldestRecord=currentRecord;
            double currentTemp=Double.parseDouble(currentRecord.get("TemperatureF"));
            double coldestTemp=Double.parseDouble(coldestRecord.get("TemperatureF"));

            if(coldestTemp != -9999.0 && coldestTemp>currentTemp){
                coldestRecord=currentRecord;
            }
        }
        return coldestRecord;
    }
    File fileWithColdestTemperature(){
        DirectoryResource directoryResource=new DirectoryResource();
        File fileWithLowestTemperature=null;

        for(File currentFile:directoryResource.selectedFiles()){
            if(fileWithLowestTemperature == null)
                fileWithLowestTemperature=currentFile;
            double currentDayLowest= getTemperature(currentFile);
            double lowestTemperature= getTemperature(fileWithLowestTemperature);

            if(currentDayLowest != -9999.0 && currentDayLowest<lowestTemperature)
                fileWithLowestTemperature=currentFile;
        }
        return fileWithLowestTemperature;
    }

    CSVRecord coldestHumidityInFile(CSVParser parser){
        CSVRecord coldestRecord=null;
        for(CSVRecord currentRecord : parser){
            if(coldestRecord == null)
                coldestRecord=currentRecord;
            String currentHumidityStr=currentRecord.get("Humidity");
            if(currentHumidityStr.equals("N/A"))
                continue;
            double currentHumidity=Double.parseDouble(currentHumidityStr);
            double coldestHumidity=Double.parseDouble(coldestRecord.get("Humidity"));

            if(coldestHumidity>currentHumidity){
                coldestRecord=currentRecord;
            }
        }
        return coldestRecord;
    }

    File lowestHumidityInManyFiles(){
        DirectoryResource directoryResource=new DirectoryResource();
        File fileWithLowestHumidity=null;

        for(File currentFile:directoryResource.selectedFiles()){
            if(fileWithLowestHumidity == null)
                fileWithLowestHumidity=currentFile;
            double currentDayLowest= getHumidity(currentFile);
            double lowestHumidity= getHumidity(fileWithLowestHumidity);

            if(currentDayLowest<lowestHumidity)
                fileWithLowestHumidity=currentFile;
        }
        return fileWithLowestHumidity;
    }

    double averageTemperatureInFile(CSVParser parser){
        int count=0;
        double sum=0;
        for(CSVRecord record : parser){
            if(Double.parseDouble(record.get("TemperatureF")) == -9999.0)
                continue;
            sum+=Double.parseDouble(record.get("TemperatureF"));
            count += 1;
        }
        return sum/count;
    }

    double averageTemperatureWithHighHumidityInFile(CSVParser parser, int value){
        int count=0;
        double sum=0;
        for(CSVRecord record : parser){
            String humidity=record.get("Humidity");
            String temperature=record.get("TemperatureF");
            if(humidity.equalsIgnoreCase("N/A"))
                continue;
            if(Double.parseDouble(humidity) >= value){
                double temp=Double.parseDouble(temperature);
                if(temp == -9999.0)
                    continue;;
                sum+=temp;
                count += 1;
            }

        }
        return sum/count;
    }


    private double getTemperature(File currentFile) {
        return Double.parseDouble(
                coldestHourInFile(
                        new FileResource(currentFile).getCSVParser()
                ).get("TemperatureF")
        );
    }
    private double getHumidity(File currentFile) {
        return Double.parseDouble(
                coldestHumidityInFile(
                        new FileResource(currentFile).getCSVParser()
                ).get("Humidity")
        );
    }

    void testColdestHour(){
        FileResource resource=new FileResource();
        System.out.println(coldestHourInFile(resource.getCSVParser()).get("TemperatureF"));
    }

    void testColdestFiles(){
        File fileName=fileWithColdestTemperature();
        System.out.println("Coldest File is " + fileName.getName());
        System.out.println("Coldest Temperature on that day was "+getTemperature(fileName));
    }

    void testLowestHumidity(){
        FileResource resource=new FileResource();
        System.out.println(coldestHumidityInFile(resource.getCSVParser()).get("Humidity"));
    }

    void testLowestHumidityInManyFiles(){
        File fileName=lowestHumidityInManyFiles();
        System.out.println("Lowest Humidity File is " + fileName.getName());
        System.out.println("Lowest Humidity on that day was "+getHumidity(fileName));
    }

    void testAverageTemperature(){
        File fileName=lowestHumidityInManyFiles();
        System.out.println(averageTemperatureInFile(new FileResource(fileName).getCSVParser()));
    }
    void averageTemperatureWithHighHumidityInFile(){
        File fileName=lowestHumidityInManyFiles();
        try{
            double average=averageTemperatureWithHighHumidityInFile(
                    new FileResource(fileName).getCSVParser(),80
            );
            if(Double.isNaN(average))
                System.out.println("No temperature above min threshold");
            else
                System.out.println("Average temp is "+average);
        }catch (Exception exception){
            System.out.println("Exception");
        }
    }

    public static void main(String[] args) {
        ColdestTemperature temperature=new ColdestTemperature();
        temperature.averageTemperatureWithHighHumidityInFile();
    }
}
