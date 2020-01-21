package entries;

import interactions.InputInteractionElement;
import interactions.states.ToggleState;
import lib.messageservice.MessageService;
import places.Place;

public class LockChamberDoor extends Entry implements InputInteractionElement<ToggleState> {
  public LockChamberDoor(Place place) {
    super("Шлюзовая камера", false, place);
  }

  public void react(ToggleState state) {
    if (state == ToggleState.ON) {
      MessageService.showMessage("Дверь открыта");
    } else {
      MessageService.showMessage("Дверь закрыта");
    }
  }
}
