package com.prog34.entries;
import com.prog34.Shorty;
import com.prog34.lib.messageservice.MessageService;
import com.prog34.places.Place;
import com.prog34.places.House;

public class HouseDoor extends Entry {
    public HouseDoor(House house, Place place2) {
        super("дверь дома", false, house, place2);
    }

    public void openBy(Shorty shorty) {
        this.open();
        MessageService.showMessageWithNewLineEnding(shorty.getName() + " Открывает дверь наружу");
    }
}
