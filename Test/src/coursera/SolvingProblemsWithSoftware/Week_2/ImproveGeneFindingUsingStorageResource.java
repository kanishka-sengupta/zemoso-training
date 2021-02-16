package coursera.SolvingProblemsWithSoftware.Week_2;

import edu.duke.FileResource;
import edu.duke.ResourceException;
import edu.duke.StorageResource;

import java.util.ArrayList;
import java.util.List;


public class ImproveGeneFindingUsingStorageResource {
    public int findStopCodon(String dna, int startIndex, String stopCodon){

        int currentIndex= dna.indexOf(stopCodon,startIndex+3);
        while (currentIndex != -1){
            int difference=currentIndex-startIndex;
            if(difference%3 == 0)
                return currentIndex;
            else
                currentIndex= dna.indexOf(stopCodon,currentIndex+3);
        }
        return -1;
    }

    String findGene(String dna){

        dna=dna.toLowerCase();
        int startIndex=dna.indexOf("atg");
        if(startIndex == -1)
            return "";
        int tgaIndex=findStopCodon(dna,startIndex,"tga");
        int taaIndex=findStopCodon(dna,startIndex,"taa");
        int tagIndex=findStopCodon(dna,startIndex,"tag");
        int minIndex;
        if(tgaIndex == -1 || (taaIndex != -1 && taaIndex<tgaIndex))
            minIndex=taaIndex;
        else
            minIndex=tgaIndex;

        if(minIndex == -1  || (tagIndex != -1 && tagIndex<minIndex))
            minIndex=tagIndex;

        if(minIndex == -1)
            return "";
        return dna.substring(startIndex,minIndex+3);
    }

    StorageResource getAllGenes(String dna){
        StorageResource resource=new StorageResource();
        System.out.println("Printing all genes in dna: "+dna);
        String tempDna=dna;
        int startIndex=0;
        while(true){
            String gene=findGene(tempDna);
            if(gene.isEmpty())
                break;
            startIndex+=dna.indexOf(gene,startIndex)+gene.length();
            if(startIndex<tempDna.length()) {
                tempDna = dna.substring(startIndex);
            }
            else
                tempDna="";
            resource.add(gene);
        }
        return resource;
    }

    double cgRatio(String dna){
        double countOfCG=0.0;
        String toLowerCase=dna.toLowerCase();
        for (char character:toLowerCase.toCharArray()) {
            if(character == 'c' || character == 'g')
                countOfCG+=1;
        }
        return countOfCG/dna.length();
    }

    int countCTG(String dna){
        dna=dna.toLowerCase();
        int count=Part2.occurrences("ctg",dna);
        return count;
    }

    void processGenes(StorageResource storageResource){
        int largestGeneLength=0;
        List<String> genesWithMoreThanNineCharacters=new ArrayList<String>();
        List<String> genesWithHighCG=new ArrayList<String>();

        for (String gene:storageResource.data()) {
            int geneLength=gene.length();
            double geneCGRatio=cgRatio(gene);
            if(geneLength>=9){
                genesWithMoreThanNineCharacters.add(gene);
            }
            if(geneCGRatio >= 0.35){
                genesWithHighCG.add(gene);
            }
            largestGeneLength=Math.max(largestGeneLength,geneLength);
        }

        for (String gene: genesWithMoreThanNineCharacters) {
            System.out.println(gene+" , Size = " + gene.length());
        }
        for (String gene : genesWithHighCG){
            System.out.println(gene + " , CGRatio = "+ cgRatio(gene));
        }
    }

    public String LoadResourceDNA(){
        try {
            FileResource resource=new FileResource();
            return resource.asString();
        }catch (ResourceException exception){
            throw new ResourceException("None Selected");
        }
    }

    public static void main(String[] args) {
        ImproveGeneFindingUsingStorageResource improveGeneFindingUsingStorageResource=
                new ImproveGeneFindingUsingStorageResource();
        String dna=improveGeneFindingUsingStorageResource.LoadResourceDNA();
        //dna="atgtaaatgttaatgtgaatgxxxyyytaaatgxxxctgctgctgctgtga";

        improveGeneFindingUsingStorageResource.processGenes(
                improveGeneFindingUsingStorageResource.getAllGenes(dna)
        );
    }
}
