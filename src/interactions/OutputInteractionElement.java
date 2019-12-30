package interactions;
import interactions.states.ToggleState;
import lib.observer.EventManager;

public abstract class OutputInteractionElement<T extends Enum> {
  protected EventManager<T> eventManager = new EventManager<T>();
  protected T state;
  protected enum ListenAll {
    ALL
  }

  public OutputInteractionElement(T currentState) {
    this.state = currentState;
  }

  public void connect(InputInteractionElement input) {
    this.eventManager.listen(ListenAll.ALL, input);
  }

  public T getState() {
    return this.state;
  }

}
