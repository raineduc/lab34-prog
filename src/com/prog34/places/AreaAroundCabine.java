package com.prog34.places;

import com.prog34.entries.LockChamberDoor;
import com.prog34.interactions.output.Button;
import com.prog34.Shorty;
import com.prog34.lib.messageservice.MessageService;

public class AreaAroundCabine extends Place {
    protected Button openingButton = new Button();
    protected LockChamberDoor door;
    protected RocketCabine cabine;

    public AreaAroundCabine(String name, RocketCabine cabine) {
        super(name);
        this.cabine = cabine;
        this.openingButton.connect(cabine.getMotor());
    }

    public void addLockChamberDoor(LockChamberDoor door) {
        this.door = door;
        this.addEntry(door);
        cabine.getMotor().connect(this.door);
    }

    public void openLockChamberDoorBy(Shorty shorty) {
        MessageService.showMessageWithNewLineEnding(shorty.getName() + " пробует открыть дверь");
        this.openingButton.push();
    }

    public LockChamberDoor getDoor() {
      return door;
    }
}
