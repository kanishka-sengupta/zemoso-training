package coursera.SolvingProblemsWithSoftware.Week_3;

import edu.duke.FileResource;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.util.ArrayList;

public class AnalyzingCSVFiles {
    /**
     *
     * @param parser
     * @param country
     * @return info if found.
     */
    String countryInfo(CSVParser parser, String country){
        String info="";
        for (CSVRecord record: parser) {
            if(record.get("Country").equals(country)){
                info=record.get("Country")+": "+record.get("Exports")+" : "+record.get("Value (dollars)");
            }
        }
        return info.isEmpty()?"Not Found":info;
    }

    void listExportersTwoProducts(CSVParser parser,String exportItem1,String exportItem2){
        ArrayList<String> countries=new ArrayList<String>();
        for (CSVRecord record: parser) {
            String exports=record.get("Exports");
            if(exports.contains(exportItem1) && exports.contains(exportItem2)){
                countries.add(record.get("Country"));
            }
        }
        System.out.println(countries);
    }

    int numberOfExporters(CSVParser parser,String exportItem){
        int count = 0;
        for (CSVRecord record: parser) {
            if(record.get("Exports").contains(exportItem)){
                count+=1;
            }
        }
        return count;
    }

    void bigExporters(CSVParser parser,String amount){
        for (CSVRecord record: parser) {
            if(record.get("Value (dollars)").length() > amount.length()){
                System.out.print(record.get("Value (dollars)"));
                System.out.println(record.get("Country"));
            }
        }
    }

    void tester(){
        FileResource fileResource=new FileResource();
        CSVParser csvParser=fileResource.getCSVParser();
        System.out.println(countryInfo(csvParser,"Nauru"));
    }

    void testTwoItems(){
        FileResource fileResource=new FileResource();
        CSVParser csvParser=fileResource.getCSVParser();
        listExportersTwoProducts(csvParser,"fish","nuts");
    }

    void testNumberOfImporters(){
        FileResource fileResource=new FileResource();
        CSVParser csvParser=fileResource.getCSVParser();
        System.out.println(numberOfExporters(csvParser,"gold"));
    }

    void testBigExporter(){
        FileResource fileResource=new FileResource();
        CSVParser csvParser=fileResource.getCSVParser();
        bigExporters(csvParser,"$999,999,999,999");
    }

    public static void main(String[] args) {
        new AnalyzingCSVFiles().testBigExporter();

    }
}
