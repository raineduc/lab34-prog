package interactions;

import lib.observer.EventListener;

public interface InputInteractionElement<T extends Enum> extends EventListener<T> {

  default void update(T state) {
    this.react(state);
  }
  void react(T state);
}
