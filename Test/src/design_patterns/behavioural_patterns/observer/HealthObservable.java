package design_patterns.behavioural_patterns.observer;

import java.util.ArrayList;

public class HealthObservable {
    private int currentHealth=100;
    private ArrayList<Observer> allHealthObservers = new ArrayList<Observer>();

    void addObserver(Observer obs){
        allHealthObservers.add(obs);
    }

    void removeObserver(Observer obs){
        allHealthObservers.remove(obs);
    }

    void removeAllListener(){
        allHealthObservers.clear();
    }
    void setHealth(int damage){
        this.currentHealth-=damage;
        for(Observer obs: allHealthObservers){
            obs.update(damage);
        }
        if(this.currentHealth <= 0)
            removeAllListener();
    }
}
