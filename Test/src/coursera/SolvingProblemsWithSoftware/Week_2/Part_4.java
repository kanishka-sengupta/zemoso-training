package coursera.SolvingProblemsWithSoftware.Week_2;

import edu.duke.URLResource;

import java.util.ArrayList;

public class Part_4 {
    final String urlToFetch="https://www.dukelearntoprogram.com//course2/data/manylinks.html";
    Iterable getResource(String url){
        URLResource urlResource=new URLResource(url);
        return urlResource.words();
    }
    ArrayList<String> extractLink(String url, String linkToSearch){
        ArrayList<String> links=new ArrayList<String>();
        for (Object link:getResource(url)) {
            String lowerCasedString=link.toString().toLowerCase();
            int index=lowerCasedString.indexOf(linkToSearch);
            if(index != -1) {
                int start = lowerCasedString.lastIndexOf("\"", index);
                int end = lowerCasedString.indexOf("\"", index);
                links.add(link.toString().substring(start + 1, end));
            }
        }
        return links;
    }
    public static void main(String[] args) {
        Part_4 part_4=new Part_4();
        System.out.println(part_4.extractLink(part_4.urlToFetch, "youtube.com"));
    }
}
