package design_patterns.behavioural_patterns.javaObs;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Particle implements PropertyChangeListener {
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Spawning blood particle for damage: "+((int)evt.getOldValue()-(int)evt.getNewValue()));
    }
}
