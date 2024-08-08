package revers.myDomain.argsManipulation;

import java.util.ArrayList;
import java.util.List;

public class RawAllArgsSubject implements Subject {
    private ArrayList<String> listArgs;

    public List<Observer> observers = new ArrayList<Observer>();

    public RawAllArgsSubject() {
        this.listArgs = new ArrayList<String>();
    }

    @Override
    public void registerObserver(Observer ...o) {
        for (int i = 0; i < o.length; i++) {
            observers.add(o[i]);
            System.out.println("Registered Observer: " + o[i].getClass());
        }
    }
    @Override
    public void removeObserver(Observer ...o) {
        for (int i = 0; i < o.length; i++) {
            observers.remove(o[i]);

        }
    }
    @Override
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).update(this.listArgs);
            System.out.println("Notified Observer: " + observers.get(i).getClass() + "observers.get(i).update(this.listArgs) "+
                    this.listArgs +  "size" +  this.listArgs.size());
        }
    }
    public void setNewArgs(String[] args) {
        System.out.println("Setting new args: " + args);
        List<String> newArgs = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            this.listArgs.add(args[i]);
        }
        this.listArgs.clear();
        this.listArgs.addAll(newArgs);
        this.notifyObservers();
    }
}
