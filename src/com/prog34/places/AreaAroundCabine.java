package com.prog34.places;

import com.prog34.entries.LockChamberDoor;
import com.prog34.interactions.output.Button;

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

    public void pushButton() {
        this.openingButton.push();
    }
}
