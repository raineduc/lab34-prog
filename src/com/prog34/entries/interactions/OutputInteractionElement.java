package com.prog34.entries.interactions;
import com.prog34.entries.lib.observer.EventManager;

public abstract class OutputInteractionElement<T extends Enum> {
  protected EventManager<T> eventManager = new EventManager<T>();
  protected enum ListenAll {
    ALL
  }

  public void connect(InputInteractionElement input) {
    this.eventManager.listen(ListenAll.ALL, input);
  }

  public void notify(T data) {
    this.eventManager.notify(ListenAll.ALL, data);
  }
}
