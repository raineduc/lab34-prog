package entries;

public abstract class Entry {
    protected boolean opened;
    protected Place place;
    protected String name;

    public Entry(String name, boolean opened) {
        this.name = name;
        this.opened = opened;
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
