package entries;

import interactions.InputInteractionElement;
import interactions.states.ToggleState;
import lib.messageservice.MessageService;

public class LockChamberDoor extends Entry implements InputInteractionElement<ToggleState> {
  protected MessageService messageService;

  public LockChamberDoor(MessageService mes) {
    super("Шлюзовая камера", false);
    this.messageService = mes;
  }

  public void react(ToggleState state) {
    if (state == ToggleState.ON) {
      messageService.showMessage("Дверь открыта");
    } else {
      messageService.showMessage("Дверь закрыта");
    }
  }
}
