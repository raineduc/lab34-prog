public class Hangar implements Visibility{
    private HangarState state = HangarState.NORMAL;

    public void crash() {
        this.state = HangarState.CRASHED;
    }

    public void clearBy(Shorty ... shorties) {
        this.state = HangarState.CLEARED;
    }

    @Override
    public String getVisibilityInfo() {
        String visibleInfo;
        switch (this.state) {
            case CLEARED:
                visibleInfo = "расчищенное место";
                break;
            case CRASHED:
                visibleInfo = "груду обломков";
                break;
            case BURNING:
                visibleInfo = "поднимающийся столб пламени";
                break;
            default:
                visibleInfo = "ангар";
                break;
        }
        return visibleInfo;
    }
}
