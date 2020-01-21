import interactions.OutputInteractionElement;
import places.LockChamber;
import places.RocketCabine;
import lib.messageservice.MessageService;

public class Rocket extends OutputInteractionElement<RocketPosition> implements Visibility {
    private RocketTail tail = new RocketTail();
    private RocketCabine cabine = new RocketCabine();
    private Engine engine = new Engine();
    private LockChamber lockChamber = new LockChamber();
    private RocketPosition position = RocketPosition.NORMAL;

    public void explode() {
        MessageService.showMessageWithNewLineEnding("Ракета взорвалась!");
        position = RocketPosition.FLIPPED;
        MessageService.showMessageWithNewLineEnding("Ракета перевернулась набок!");
        tail.brokeOff();
        engine.damage();
        cabine.brokeIlluminators();
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
