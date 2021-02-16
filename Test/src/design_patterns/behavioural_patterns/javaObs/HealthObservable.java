package design_patterns.behavioural_patterns.javaObs;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class HealthObservable {
    private int currHealth=100;
    private PropertyChangeSupport propertyChangeSupport;

    public HealthObservable(){
        this.propertyChangeSupport=new PropertyChangeSupport(this);
    }

    public void addObserver(PropertyChangeListener plc){
        this.propertyChangeSupport.addPropertyChangeListener(plc);
    }
    public void removeObserver(PropertyChangeListener plc){
        this.propertyChangeSupport.removePropertyChangeListener(plc);
    }
    public void setHealth(int damage){
        propertyChangeSupport.firePropertyChange(
                "damage",
                this.currHealth,
                this.currHealth-damage
        );
        this.currHealth-=damage;
        if(currHealth<=0){
            for(PropertyChangeListener plc:this.propertyChangeSupport.getPropertyChangeListeners())
                removeObserver(plc);
        }
    }

}
