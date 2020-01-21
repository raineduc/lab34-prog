package interactions.output;

import interactions.OutputInteractionElement;
import interactions.states.ToggleState;

public class Button extends OutputInteractionElement<ToggleState> {
  protected ToggleState state = ToggleState.OFF;

  public ToggleState getState() {
    return this.state;
  }

  public void push() {
    this.state = ToggleState.ON;
    this.notify(this.state);
  }
}
