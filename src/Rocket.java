import java.util.ArrayList;

public class Rocket {
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

}
