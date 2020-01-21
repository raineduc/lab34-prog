package com.prog34.entries;
import com.prog34.places.Place;
import com.prog34.places.House;

public class HouseDoor extends Entry {
    public HouseDoor(House house, Place place2) {
        super("дверь дома", false, house, place2);
    }
}
