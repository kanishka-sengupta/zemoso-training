package design_patterns.behavioural_patterns.observer;

public class Particle implements Observer<Integer>{
    public void update(Integer value) {
        System.out.println("Emitting blood particles for damage: "+value);
    }
}
