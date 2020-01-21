package com.prog34.places;

import com.prog34.entries.LockChamberDoor;
import com.prog34.interactions.duplex.ElectricMotor;
import com.prog34.interactions.output.Button;

public class LockChamber extends Place {
    protected Button openingButton = new Button();
    protected ElectricMotor openingMotor = new ElectricMotor();
    protected LockChamberDoor door;

    public LockChamber(String name) {
        super(name);
        this.openingButton.connect(this.openingMotor);
        this.door = new LockChamberDoor(this);
        this.addEntry(this.door);
        this.openingMotor.connect(this.door);
    }
    public void pushButton() {
        this.openingButton.push();
    }
}
