package design_patterns.behavioural_patterns.javaObs;

public class ObserverDesignPattern{
    public static void main(String[] args) {
        HealthObservable healthObservable=new HealthObservable();
        Audio audio=new Audio();
        Particle particle=new Particle();
        healthObservable.addObserver(audio);
        healthObservable.addObserver(particle);
        healthObservable.setHealth(50);

        healthObservable.setHealth(20);
        healthObservable.setHealth(30);

        healthObservable.setHealth(10);
    }
}
