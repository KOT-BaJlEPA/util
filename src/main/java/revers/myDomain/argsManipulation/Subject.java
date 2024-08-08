package revers.myDomain.argsManipulation;

public interface Subject {
    public void registerObserver(Observer ...o);
    public void removeObserver(Observer ...o);
    public void notifyObservers();
}
