package com.prog34;

import com.prog34.ShortyEngineer;
import com.prog34.interactions.OutputInteractionElement;
import com.prog34.lib.messageservice.MessageService;
import com.prog34.places.LockChamber;
import com.prog34.places.RocketCabine;

public class Rocket extends OutputInteractionElement<RocketPosition> implements Visibility {
    private RocketTail tail = new RocketTail();
    private RocketCabine cabine = new RocketCabine("кабина");
    private Engine engine = new Engine();
    private LockChamber lockChamber = new LockChamber("шлюзовая камера");
    private RocketPosition position = RocketPosition.NORMAL;

    public void explode() {
        MessageService.showMessageWithNewLineEnding("Ракета взорвалась!");
        position = RocketPosition.FLIPPED;
        MessageService.showMessageWithNewLineEnding("Ракета перевернулась набок!");
        tail.brokeOff();
        engine.damage();
        cabine.brokeIlluminators();
        this.notify(position);
    }

    public void openLockChamberDoorBy(Shorty shorty) {
      lockChamber.pushButton();
    }

    public void openLockChamberDoorBy(ShortyEngineer shortyEngineer) {

    }

    public RocketPosition getPosition() {
        return this.position;
    }

    @Override
    public String getVisibilityInfo() {
        return (this.position == RocketPosition.FLIPPED) ? "ракету, перевернутую набок" : "ракету";
    }
}
