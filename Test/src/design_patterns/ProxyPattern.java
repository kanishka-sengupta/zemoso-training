package design_patterns;

interface Image{
    void open();
}
class RealImage implements Image{

    private String fileName;

    public RealImage(String fileName){
        this.fileName=fileName;
        loadFromDisk();
    }

    @Override
    public void open() {
        System.out.println("Displaying "+fileName);
    }
    void loadFromDisk(){
        System.out.println("Loading from Disk "+fileName);
    }
}
class ProxyImage implements Image {
    private String fileName;
    private RealImage realImage;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void open() {
        if(realImage==null)
            realImage=new RealImage(fileName);
        realImage.open();
    }
}
public class ProxyPattern {
    public static void main(String[] args) {
        Image image=new ProxyImage("testFile.jpg");
        image.open();
        System.out.println();
        image.open();
    }
}
