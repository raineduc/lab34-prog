package com.prog34.lib.observer;

import java.util.ArrayList;
import java.util.HashMap;

public class EventManager<T> {
  private HashMap<Enum, ArrayList<EventListener<T>>> listeners = new HashMap<>();
  public void listen(Enum type, EventListener<T> listener) {
    ArrayList<EventListener<T>> listenersArray = listeners.get(type);
    if (listenersArray == null) {
      listenersArray = new ArrayList<EventListener<T>>();
      listeners.put(type, listenersArray);
    }
    listenersArray.add(listener);
  }
  public void removeListener(Enum type, EventListener listener) {
    ArrayList<EventListener<T>> listenersArray = listeners.get(type);
    listenersArray.remove(listener);
  }
  public void notify(Enum type, T data) {
    ArrayList<EventListener<T>> listenersArray = listeners.get(type);

    for (EventListener<T> listener: listenersArray) {
      listener.update(data);
    }
  }
}
