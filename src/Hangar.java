public class Hangar {
    private HangarState state = HangarState.NORMAL;

    public void crash() {
        this.state = HangarState.CRASHED;
    }

    public void clearBy(Shorty ... shorties) {
        this.state = HangarState.CLEARED;
    }

}
