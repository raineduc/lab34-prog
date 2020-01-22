package com.prog34.places;
import com.prog34.Hangar;
import com.prog34.Shorty;
import com.prog34.lib.messageservice.MessageService;
import com.prog34.places.AreaAroundHangar;

import java.util.ArrayList;

public class AreaAroundHangar extends Place {
  protected Hangar hangar;

  public AreaAroundHangar(Hangar hangar) {
    super("Место у ангара");
    this.hangar = hangar;
  }

  public void clearPlaceBy(ArrayList<Shorty> shorties) {
    for (Shorty shorty: shorties) {
      MessageService.showMessageWithNewLineEnding(shorty.getName() + " трудится в поте лица...");
    }
    hangar.clear();
  }
}
