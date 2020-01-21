package com.prog34.places;

import com.prog34.entries.HouseDoor;

public class House extends Place {
    public House (String name) {
        super(name);
        HouseDoor door = new HouseDoor("дверь дома", true, this);
        this.addEntry(door);
    }
}
