import java.util.ArrayList;

public class Rocket implements Visibility {
    private RocketTail tail = new RocketTail();
    private RocketCabine cabine = new RocketCabine();
    private Engine engine = new Engine();
    private LockChamber lockChamber = new LockChamber();
    private RocketPosition position = RocketPosition.NORMAL;

    public void explode() {
        tail.brokeOff();
        engine.damage();
        cabine.brokeIlluminators();
        position = RocketPosition.FLIPPED;
    }

    public void openLockChamberDoorBy(Shorty shorty) {

    }

    public void openLockChamberDoorBy(ShortyEngineer shortyEngineer) {

    }

    public RocketPosition getPosition() {
        return this.position;
    }

    @Override
    public String getVisibilityInfo() {
        String visibleInfo;
        if (this.position == position.FLIPPED) {
            return "ракету, перевернутую набок";
        } else {
            return "ракету";
        }
    }
}
