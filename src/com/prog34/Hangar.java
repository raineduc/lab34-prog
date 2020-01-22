package com.prog34;

import com.prog34.interactions.InputInteractionElement;
import com.prog34.lib.messageservice.MessageService;
import com.prog34.places.AreaAroundHangar;

public class Hangar implements Visibility, InputInteractionElement<RocketPosition> {
  private HangarState state = HangarState.NORMAL;
  private AreaAroundHangar areaAroundHangar = new AreaAroundHangar(this);

  public void crash() {
    this.state = HangarState.CRASHED;
    MessageService.showMessageWithNewLineEnding("Взорвался ангар!");
  }

  public void clear() {
    this.state = HangarState.CLEARED;
  }

  @Override
  public String getVisibilityInfo() {
    String visibleInfo;
    switch (this.state) {
      case CLEARED:
        visibleInfo = "расчищенное место";
        break;
      case CRASHED:
        visibleInfo = "груду дымящихся развалин";
        break;
      case BURNING:
        visibleInfo = "поднимающийся кверху столб пламени и дыма";
        break;
      default:
        visibleInfo = "ангар";
        break;
    }
    return visibleInfo;
  }

  public AreaAroundHangar getAreaAroundHangar() {
    return areaAroundHangar;
  }

  @Override
  public void react(RocketPosition state) {
    if (state == RocketPosition.FLIPPED) {
      this.crash();
    }
  }
}
