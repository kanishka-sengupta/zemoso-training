package design_patterns;

import java.util.ArrayList;

class HTMLElement{
    String name;
    String text;

    ArrayList<HTMLElement> elements;

    protected HTMLElement(String name, String text){
        this.elements=new ArrayList<HTMLElement>();
        this.name=name;
        this.text=text;
    }
    @Override
    public String toString(){
        String currentElement="";
        currentElement+="<"+this.name+">\n";
        if(this.text.length()>0)
            currentElement+=this.text;
        for (HTMLElement e:
             elements) {
            currentElement+=e.toString();
        }
        currentElement+="</"+this.name+">\n";
        return currentElement;
    }
}

class SimpleHTMLBuilder{
    HTMLElement root;

    public SimpleHTMLBuilder(String rootName){
        root=new HTMLElement(rootName,"");
    }
    //Simple Builder
    void addChild(String childName,String childText){
        HTMLElement newElement=new HTMLElement(childName,childText);
        root.elements.add(newElement);
    }
    //Fluent Builder
    SimpleHTMLBuilder addChildFluent(String childName,String childText){
        HTMLElement newElement=new HTMLElement(childName,childText);
        root.elements.add(newElement);
        return this;
    }

    @Override
    public String toString() {
        return root.toString();
    }
}
public class Builder {
    public static void main(String[] args) {
        SimpleHTMLBuilder simpleHTMLBuilder=new SimpleHTMLBuilder("ul");
        simpleHTMLBuilder.addChild("li","hello");
        simpleHTMLBuilder.addChild("li","world");
        System.out.println(simpleHTMLBuilder.toString());

        //FluentBuilder Example
        SimpleHTMLBuilder fluentBuilder=new SimpleHTMLBuilder("ul");
        fluentBuilder.addChildFluent("li","hello")
                        .addChildFluent("li","world");
        System.out.println(simpleHTMLBuilder.toString());
    }
}
