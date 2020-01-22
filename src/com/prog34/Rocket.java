package com.prog34;

import com.prog34.ShortyEngineer;
import com.prog34.entries.Illuminator;
import com.prog34.entries.LockChamberDoor;
import com.prog34.interactions.OutputInteractionElement;
import com.prog34.lib.messageservice.MessageService;
import com.prog34.places.AreaAroundCabine;
import com.prog34.places.LockChamber;
import com.prog34.places.RocketCabine;

import java.util.ArrayList;

public class Rocket extends OutputInteractionElement<RocketPosition> implements Visibility {
    private RocketTail tail = new RocketTail();
    private RocketCabine cabine = new RocketCabine("кабина");
    private AreaAroundCabine areaAroundCabine = new AreaAroundCabine("Около кабины", cabine);
    private Engine engine = new Engine();
    private LockChamber lockChamber = new LockChamber("шлюзовая камера");
    private RocketPosition position = RocketPosition.NORMAL;

    public Rocket() {
      cabine.createIlluminators(areaAroundCabine);
      LockChamberDoor lockChamberDoor = new LockChamberDoor(lockChamber, areaAroundCabine);
      areaAroundCabine.addLockChamberDoor(lockChamberDoor);
      lockChamber.addLockChamberDoor(lockChamberDoor);
    }

    public void explode() {
        MessageService.showMessageWithNewLineEnding("Ракета взорвалась!");
        position = RocketPosition.FLIPPED;
        MessageService.showMessageWithNewLineEnding("Ракета перевернулась набок!");
        tail.brokeOff();
        engine.damage();
        cabine.brokeIlluminators();
        this.notify(position);
    }

    public RocketPosition getPosition() {
        return this.position;
    }

    @Override
    public String getVisibilityInfo() {
        return (this.position == RocketPosition.FLIPPED) ? "ракету, перевернутую набок" : "ракету";
    }

    public ArrayList<Illuminator> getIlluminators() {
      return cabine.getIlluminators();
  }

    public AreaAroundCabine getAreaAroundCabine() {
      return areaAroundCabine;
    }
    public RocketCabine getCabine() {
      return cabine;
    }
}
