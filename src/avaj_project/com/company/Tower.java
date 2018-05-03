package avaj_project.com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Tower{

    private List<Flyable> observers = new LinkedList<Flyable>();

    public void register(Flyable flyable){
//        if (observers.contains(flyable))
//            return;
//        else
            observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        int j;
        for (int i = 0; i < (j = observers.size()); i++){
            observers.get(i).updateConditions();
            if (j > observers.size())
                i--;
        }
    }
}
