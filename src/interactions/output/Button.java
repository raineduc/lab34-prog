package interactions.output;

import interactions.OutputInteractionElement;
import interactions.states.ToggleState;
import lib.observer.EventManager;

public class Button extends OutputInteractionElement<ToggleState> {
  public Button() {
    super(ToggleState.OFF);
  }

  public ToggleState getState() {
    return this.state;
  }

  public void push() {
    this.state = ToggleState.ON;
  }
}
