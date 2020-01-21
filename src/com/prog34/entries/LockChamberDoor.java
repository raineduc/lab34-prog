package com.prog34.entries;

import com.prog34.interactions.InputInteractionElement;
import com.prog34.interactions.states.ToggleState;
import com.prog34.lib.messageservice.MessageService;
import com.prog34.places.Place;

public class LockChamberDoor extends Entry implements InputInteractionElement<ToggleState> {
  public LockChamberDoor(Place place) {
    super("Шлюзовая камера", false, place);
  }

  public void react(ToggleState state) {
    if (state == ToggleState.ON) {
      MessageService.showMessage("Дверь открыта");
      this.open();
    } else {
      MessageService.showMessage("Дверь закрыта");
      this.close();
    }
  }
}
