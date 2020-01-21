package interactions.duplex;

import interactions.DuplexInteractionElement;
import interactions.states.ElectricMotorState;
import interactions.states.ToggleState;

public class ElectricMotor extends DuplexInteractionElement<ToggleState, ToggleState> {
  protected String stateMessage = "Мотор остановлен";
  protected ElectricMotorState state;

  public ElectricMotor(ElectricMotorState state) {
    this.state = state;
  }

  public ElectricMotor() {
    this.state = ElectricMotorState.NOT_WORK;
  }

  public void react(ToggleState state) {
    if (this.state == ElectricMotorState.NOT_WORK) {
      this.stateMessage = "Мотор не работает";
      this.notify(ToggleState.OFF);
    }
    else {
      if (state == ToggleState.ON) {
        this.state = ElectricMotorState.RUNNING;
        this.notify(ToggleState.ON);
      } else {
        this.state = ElectricMotorState.STOPPED;
        this.notify(ToggleState.OFF);
      }
    }
  }
}
