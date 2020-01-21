import entries.Entry;
import entries.HouseDoor;
import places.Place;

public class House extends Place {
    public House () {
        HouseDoor door = new HouseDoor("дверь дома", true);
        this.addEntry(door);
    }
}
