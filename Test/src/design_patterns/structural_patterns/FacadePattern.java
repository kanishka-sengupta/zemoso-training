package design_patterns.structural_patterns;

interface ISoda{
    void purchaseSoda();
}
class PepsiCola implements ISoda{
    @Override
    public void purchaseSoda() {
        System.out.println("Purchasing Pepsi");
    }
}
class CocaCola implements ISoda{
    @Override
    public void purchaseSoda() {
        System.out.println("Purchasing Coke");
    }
}
class ThumbsUp implements ISoda{
    @Override
    public void purchaseSoda() {
        System.out.println("Purchasing ThumbsUp");
    }
}
class SodaMachine{

    ISoda Coke,Pepsi,ThumbsUp;
    public SodaMachine(){
        this.Coke=new CocaCola();
        this.Pepsi=new PepsiCola();
        this.ThumbsUp=new ThumbsUp();
    }

    public void  buyPepsi(){
        Pepsi.purchaseSoda();
    }
    public void  buyCola(){
        Coke.purchaseSoda();
    }
    public void  buyThumbsUp(){
        ThumbsUp.purchaseSoda();
    }
}
public class FacadePattern {
    public static void main(String[] args) {
        SodaMachine sodaMachine=new SodaMachine();
        sodaMachine.buyThumbsUp();
    }
}
