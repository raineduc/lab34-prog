package com.prog34.entries;
import com.prog34.places.Place;

public class Illuminator extends Entry {
    private boolean isBroken = false;

    public Illuminator(String name, boolean opened, Place place) {
        super(name, opened, place);
    }
    public void broke() {
        this.isBroken = true;
    }

}
