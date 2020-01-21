package com.prog34.places;

import com.prog34.entries.Entry;

import java.util.ArrayList;

public abstract class Place {
    protected ArrayList<Entry> entries = new ArrayList<>();

    public void addEntry(Entry entry) {
        this.entries.add(entry);
    }
    public void removeEntry(Entry entry) {
        this.entries.remove(entry);
    }
    public ArrayList<Entry> getEntries() {
        return entries;
    }
}
