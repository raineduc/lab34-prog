package com.prog34.interactions.duplex;

import com.prog34.ShortyEngineer;
import com.prog34.interactions.DuplexInteractionElement;
import com.prog34.interactions.states.ElectricMotorState;
import com.prog34.interactions.states.ToggleState;
import com.prog34.lib.messageservice.MessageService;

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
      MessageService.showMessageWithNewLineEnding("Мотор не работает");
    }
    else {
      if (state == ToggleState.ON) {
        this.state = ElectricMotorState.RUNNING;
        this.notify(ToggleState.ON);
        MessageService.showMessageWithNewLineEnding("Мотор в действии");
      } else {
        this.state = ElectricMotorState.STOPPED;
        this.notify(ToggleState.OFF);
        MessageService.showMessageWithNewLineEnding("Мотор остановлен");
      }
    }
  }

  public void fixByEngineer(ShortyEngineer shorty) {
    this.state = ElectricMotorState.STOPPED;
    MessageService.showMessageWithNewLineEnding(shorty.getName() + " починил электромотор");
  }
}
