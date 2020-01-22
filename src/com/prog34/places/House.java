package com.prog34.places;

import com.prog34.entries.HouseDoor;
import com.prog34.surfaces.HouseFloor;

public class House extends Place {
    protected HouseDoor door;
    protected HouseFloor floor = new HouseFloor();

    public House (String name) {
        super(name);
    }

    public void addHouseDoor(HouseDoor door) {
        this.addEntry(door);
        this.door = door;
    }

    public HouseFloor getFloor() {
        return floor;
    }
}
