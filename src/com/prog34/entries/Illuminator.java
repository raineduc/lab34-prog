package com.prog34.entries;
import com.prog34.places.Place;

public class Illuminator extends Entry {
    private boolean isBroken = false;

    public Illuminator(Place place1, Place place2) {
        super("иллюминатор", false, place1, place2);
    }
    public void broke() {
        this.isBroken = true;
    }

}
