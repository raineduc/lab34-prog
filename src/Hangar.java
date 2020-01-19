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
                visibleInfo = "груду дымящихся развалин";
                break;
            case BURNING:
                visibleInfo = "поднимающийся кверху столб пламени и дыма";
                break;
            default:
                visibleInfo = "ангар";
                break;
        }
        return visibleInfo;
    }
}
