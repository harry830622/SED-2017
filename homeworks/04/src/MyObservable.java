import java.util.*;

public abstract class MyObservable {
  private List<MyObserver> observers;

  protected MyObservable() {
    observers = new ArrayList<MyObserver>();
  }

  public void attachObserver(MyObserver observer) {
    observers.add(observer);
  }

  public void detachObserver(MyObserver observer) {
    observers.remove(observer);
  }

  public void notifyObservers() {
    for (MyObserver observer : observers) {
      observer.update(this);
    }
  }

  // public abstract State getState();
  // public abstract void setState(State newState);
}
