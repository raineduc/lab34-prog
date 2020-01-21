package com.prog34.entries.interactions;

import com.prog34.entries.lib.observer.EventListener;

public interface InputInteractionElement<T extends Enum> extends EventListener<T> {

  default void update(T state) {
    this.react(state);
  }
  void react(T state);
}
