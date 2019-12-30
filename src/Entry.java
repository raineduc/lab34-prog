public abstract class Entry {
    private boolean opened;
    private Place place;
    private String name;

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
