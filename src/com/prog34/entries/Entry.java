package com.prog34.entries;
import com.prog34.places.Place;

public abstract class Entry {
    protected boolean opened;
    protected Place place1;
    protected Place place2;
    protected String name;

    public Entry(String name, boolean opened, Place place1, Place place2) {
        this.name = name;
        this.opened = opened;
        this.place1 = place1;
        this.place2 = place2;
    }

    public Place getPlace1() {
        return this.place1;
    }

    public Place getPlace2() {
        return this.place2;
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
