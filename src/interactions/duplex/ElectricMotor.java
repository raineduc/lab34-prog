package interactions.duplex;

import interactions.DuplexInteractionElement;
import interactions.states.ElectricMotorState;
import interactions.states.ToggleState;

public class ElectricMotor extends DuplexInteractionElement<ElectricMotorState, ToggleState> {
  protected String stateMessage = "Мотор остановлен";

  public ElectricMotor() {
    super(ElectricMotorState.STOPPED);
  }

  public void react(ToggleState state) {
    if (this.state == ElectricMotorState.NOT_WORK) {
      this.stateMessage = "Мотор не работает";
    }
    else {
      if (state == ToggleState.ON) {
        this.state = ElectricMotorState.RUNNING;
      } else {
        this.state = ElectricMotorState.STOPPED;
      }
    }
  }
}
