public class Illuminator extends Entry{
    private boolean isBroken = false;

    public Illuminator(String name, boolean opened) {
        super(name, opened);
    }
    public void broke() {
        this.isBroken = true;
    }

}
