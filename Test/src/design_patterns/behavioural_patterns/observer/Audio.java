package design_patterns.behavioural_patterns.observer;

public class Audio implements Observer<Integer>{
    public void update(Integer value) {
        System.out.println("Playing SFX for appropriate Damage:" + value);
    }
}
