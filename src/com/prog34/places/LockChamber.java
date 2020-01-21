package com.prog34.places;

import com.prog34.ShortyEngineer;
import com.prog34.entries.LockChamberDoor;
import com.prog34.interactions.duplex.ElectricMotor;
import com.prog34.interactions.output.Button;
import com.prog34.lib.messageservice.MessageService;

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

    public void fixMotorByEngineer(ShortyEngineer shorty) {
        this.openingMotor.fixByEngineer(shorty);
        MessageService.showMessageWithNewLineEnding(shorty.getName() + " починил мотор, проход в шлюзовую камеру свободен");
    }
}
