package com.prog34.entries.places;

import com.prog34.entries.LockChamberDoor;
import com.prog34.entries.interactions.output.Button;
import com.prog34.entries.interactions.duplex.ElectricMotor;

public class LockChamber extends Place {
    protected Button openingButton = new Button();
    protected ElectricMotor openingMotor = new ElectricMotor();
    protected LockChamberDoor door;

    public LockChamber() {
        super();
        this.openingButton.connect(this.openingMotor);
        this.door = new LockChamberDoor(this);
        this.addEntry(this.door);
        this.openingMotor.connect(this.door);
    }
    public void pushButton() {
        this.openingButton.push();
    }
}
