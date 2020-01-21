package entries;
import places.Place;

public class Illuminator extends Entry {
    private boolean isBroken = false;

    public Illuminator(String name, boolean opened, Place place) {
        super(name, opened, place);
    }
    public void broke() {
        this.isBroken = true;
    }

}
