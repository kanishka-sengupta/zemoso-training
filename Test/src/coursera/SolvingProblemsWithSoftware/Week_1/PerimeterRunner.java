package coursera.SolvingProblemsWithSoftware.Week_1;

import edu.duke.*;

import java.io.File;

public class PerimeterRunner {

    Shape convertFileToShape(File file){
        FileResource fileResource=new FileResource(file);
        return new Shape(fileResource);
    }

    public int getNumPoints(Shape s){
        int count=0;
        for(Point p : s.getPoints())
            count+=1;
        return count;
    }

    public double getAverageLength(Shape s){
        return getPerimeter(s)/getNumPoints(s);
    }

    public double getLargestSide(Shape s){
        Point previousPoint = s.getLastPoint();
        double max=0.0;
        for(Point currentPoint:s.getPoints()){
            double currentDistance=previousPoint.distance(currentPoint);
            max=Math.max(currentDistance,max);
        }
        return max;
    }

    public double getLargestX(Shape s){
        double maxX = 0.0;
        for (Point p:s.getPoints()){
            maxX=Math.max(p.getX(),maxX);
        }
        return maxX;
    }

    public double getLargestPerimeterMultipleFiles(){
        DirectoryResource directoryResource=new DirectoryResource();
        double largestPerimeter=0.0;
        for (File file: directoryResource.selectedFiles()) {
            Shape s=convertFileToShape(file);
            largestPerimeter=Math.max(largestPerimeter,getPerimeter(s));
        }
        return largestPerimeter;
    }

    public File getFileWithLargestPerimeter(){
        DirectoryResource directoryResource=new DirectoryResource();
        double largestPerimeter=0.0;
        File largestPerimeterFile=null;
        for (File file: directoryResource.selectedFiles()) {
            Shape s=convertFileToShape(file);
            double currentPerimeter=getPerimeter(s);
            if(currentPerimeter>largestPerimeter){
                largestPerimeter=currentPerimeter;
                largestPerimeterFile=file;
            }
        }
        return largestPerimeterFile;
    }

    public double getPerimeter (Shape s) {
        // Start with totalPerim = 0
        double totalPerim = 0.0;
        // Start wth prevPt = the last point 
        Point prevPt = s.getLastPoint();
        // For each point currPt in the shape,
        for (Point currPt : s.getPoints()) {
            // Find distance from prevPt point to currPt 
            double currDist = prevPt.distance(currPt);
            // Update totalPerim by currDist
            totalPerim = totalPerim + currDist;
            // Update prevPt to be currPt
            prevPt = currPt;
        }
        // totalPerim is the answer
        return totalPerim;
    }

    public void testPerimeter () {
        FileResource fr = new FileResource();
        Shape s = new Shape(fr);
        double length = getPerimeter(s);
        int numberOfPoints=getNumPoints(s);
        System.out.println("perimeter = " + length + " points = " + numberOfPoints);
        System.out.println("average = " + getAverageLength(s));
        System.out.println("largest side = " + getLargestSide(s));
        System.out.println("Largest X = "+getLargestX(s));
    }
    public void testPerimeterMultipleFiles(){
        System.out.println(getLargestPerimeterMultipleFiles());
        System.out.println(getFileWithLargestPerimeter().getName());
    }
    public static void main (String[] args) {
        PerimeterRunner pr = new PerimeterRunner();
        //pr.testPerimeter();
        pr.testPerimeterMultipleFiles();
    }
}
