package com.prog34.places;

import com.prog34.ShortyEngineer;
import com.prog34.entries.LockChamberDoor;
import com.prog34.interactions.duplex.ElectricMotor;
import com.prog34.interactions.output.Button;
import com.prog34.lib.messageservice.MessageService;

public class LockChamber extends Place {
    protected Button openingButton = new Button();
    protected LockChamberDoor door;

    public LockChamber(String name) {
        super(name);
    }

    public void addLockChamberDoor(LockChamberDoor door) {
        this.addEntry(door);
        this.door = door;
    }

}
