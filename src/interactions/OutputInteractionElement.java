package interactions;
import interactions.states.ToggleState;
import lib.observer.EventManager;

import java.util.List;

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
