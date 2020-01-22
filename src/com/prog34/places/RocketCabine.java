package com.prog34.places;

import com.prog34.ShortyEngineer;
import com.prog34.entries.Illuminator;
import com.prog34.lib.messageservice.MessageService;
import com.prog34.interactions.duplex.ElectricMotor;

import java.util.ArrayList;

public class RocketCabine extends Place {
    protected ArrayList<Illuminator> illuminators = new ArrayList<>(4);
    protected ElectricMotor openingMotor = new ElectricMotor();

    public RocketCabine(String name) {
        super(name);
    }

    public void pushIlluminatorsToEntries() {
        for (int i = 0; i < 4; i++)
            illuminators.get(i).open();
    }

    public void createIlluminators(Place place2) {
        for (int i = 0; i < 4; i++) {
            Illuminator illuminator = new Illuminator(this, place2);
            this.addEntry(illuminator);
            illuminators.add(illuminator);
        }
    }

    public ArrayList<Illuminator> getIlluminators() {
        return illuminators;
    }

    public void brokeIlluminators() {
        for (int i = 0; i < 4; i++)
            illuminators.get(i).broke();
        this.pushIlluminatorsToEntries();
        MessageService.showMessageWithNewLineEnding("Вышиблены стёкла иллюминаторов!");
    }

    public void fixMotorByEngineer(ShortyEngineer shorty) {
        this.openingMotor.fixByEngineer(shorty);
        MessageService.showMessageWithNewLineEnding(shorty.getName() + " починил мотор, проход в шлюзовую камеру свободен");
    }

    public ElectricMotor getMotor() {
        return this.openingMotor;
    }
}
