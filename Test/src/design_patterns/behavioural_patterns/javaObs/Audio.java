package design_patterns.behavioural_patterns.javaObs;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Audio implements PropertyChangeListener {
    public void propertyChange(PropertyChangeEvent evt) {
        System.out.println("Playing audio for damage: "+((int)evt.getOldValue()-(int)evt.getNewValue()));
    }
}
