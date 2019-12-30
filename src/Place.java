import java.util.ArrayList;

public abstract class Place {
    public ArrayList<Entry> entries = new ArrayList<>();

    public void addEntry(Entry entry) {
        this.entries.add(entry);
    }
    public void removeEntry(Entry entry) {

    }
    public ArrayList<Entry> getEntries() {
        return entries;
    }
}
