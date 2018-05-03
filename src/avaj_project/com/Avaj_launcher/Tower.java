package avaj_project.com.Avaj_launcher;

import java.util.LinkedList;
import java.util.List;

public class Tower{

    private List<Flyable> observers = new LinkedList<Flyable>();

    public void register(Flyable flyable){
        if (observers.contains(flyable))
            return;
        else
            observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){

    }
}
