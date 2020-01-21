package com.prog34.entries;
import com.prog34.entries.places.Place;

public abstract class Entry {
    protected boolean opened;
    protected Place place;
    protected String name;

    public Entry(String name, boolean opened, Place place) {
        this.name = name;
        this.opened = opened;
        this.place = place;
    }

    public Place getPlace() {
        return this.place;
    }

    public boolean IsEntryOpened() {
        return this.opened;
    }

    public void open() {
        this.opened = true;
    }

    public void close() {
        this.opened = false;
    }
}
