package lib.observer;
import java.util.HashMap;
import java.util.ArrayList;
import lib.observer.EventListener;

public class EventManager<T> {
  private HashMap<Enum, ArrayList<EventListener>> listeners = new HashMap<>();
  public void listen(Enum type, EventListener listener) {
    ArrayList<EventListener> listenersArray = listeners.get(type);
    if (listenersArray == null) {
      listenersArray = new ArrayList<EventListener>();
      listeners.put(type, listenersArray);
    }
    listenersArray.add(listener);
  }
  public void removeListener(Enum type, EventListener listener) {
    ArrayList<EventListener> listenersArray = listeners.get(type);
    listenersArray.remove(listener);
  }
  public void notify(Enum type, T data) {
    ArrayList<EventListener> listenersArray = listeners.get(type);

    for (EventListener listener: listenersArray) {
      listener.update(data);
    }
  }
}
