package com.prog34.entries;

import com.prog34.entries.Visibility;
import com.prog34.entries.interactions.InputInteractionElement;

public class Hangar implements Visibility, InputInteractionElement<RocketPosition> {
  private HangarState state = HangarState.NORMAL;

  public void crash() {
    this.state = HangarState.CRASHED;
  }

  public void clearBy(Shorty[] shorties) {
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

  @Override
  public void react(RocketPosition state) {
    if (state == RocketPosition.FLIPPED) {
      this.crash();
    }
  }
}
