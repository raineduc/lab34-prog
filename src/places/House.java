package places;

import entries.HouseDoor;

public class House extends Place {
    public House () {
        HouseDoor door = new HouseDoor("дверь дома", true, this);
        this.addEntry(door);
    }
}
