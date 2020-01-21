package com.prog34.places;

import com.prog34.entries.HouseDoor;

public class House extends Place {
    protected HouseDoor door = new HouseDoor("дверь дома", true, this);
    public House (String name) {
        super(name);
        this.addEntry(door);
    }
}
