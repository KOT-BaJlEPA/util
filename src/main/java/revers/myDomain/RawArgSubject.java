package revers.myDomain;

import revers.myDomain.observerPattern.Observer;
import revers.myDomain.observerPattern.Subject;

import java.util.ArrayList;
import java.util.List;

public class RawArgSubject implements Subject {
    private ArrayList<String> listArgs;

    public List<Observer> observers = new ArrayList<Observer>();

    public RawArgSubject() {
        this.listArgs = new ArrayList<String>();
    }

    @Override
    public void registerObserver(Observer ...o) {
        for (int i = 0; i < o.length; i++) {
            observers.add(o[i]);

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
        }
    }
    public void setNewArgs(String ...args) {
        List<String> newArgs = new ArrayList<>();
        for (int i = 0; i < args.length; i++) {
            this.listArgs.add(args[i]);
        }
        this.listArgs.clear();
        this.listArgs.addAll(newArgs);
        this.notifyObservers();
    }
}
