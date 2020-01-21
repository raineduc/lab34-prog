package com.prog34.entries;

import com.prog34.entries.interactions.InputInteractionElement;
import com.prog34.entries.interactions.states.ToggleState;
import com.prog34.entries.lib.messageservice.MessageService;
import com.prog34.entries.places.Place;

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
