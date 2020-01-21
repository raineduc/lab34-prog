import interactions.OutputInteractionElement;
import places.LockChamber;
import places.RocketCabine;

public class Rocket extends OutputInteractionElement<RocketPosition> implements Visibility {
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
        this.notify(position);
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
        return (this.position == RocketPosition.FLIPPED) ? "ракету, перевернутую набок" : "ракету";
    }
}
