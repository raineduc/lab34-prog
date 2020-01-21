import lib.messageservice.MessageService;
import places.Place;
public class Shorty {
    protected String name;
    protected HealthStatus health;
    protected Place currentPlace;
    protected Cover cover;

    public Shorty(String name) {
        this.name = name;
    }

    public void heal() {
        if (health == HealthStatus.INJURED)
            health = HealthStatus.UNHARMED;
    }

    public void sleepIn(Place place) {

    }

    public void goToPlace(Place place) {

    }

    public void lookAt(Visibility object) {
        MessageService.showMessageWithNewLineEnding(this.name + " увидел " + object.getVisibilityInfo());
    }

    public void takeCover(Cover cover) {
        this.cover = cover;
    }
}
