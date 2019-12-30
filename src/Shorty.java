public class Shorty {
    public String name;
    public HealthStatus health;
    public Place currentPlace;
    public Cover cover;

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

    /*public static void lookAtTheRocket(Rocket rocket, Shorty ... shorties){
        if (rocket.getPosition() == RocketPosition.FLIPPED) {
            // увидели, что ракету перевернуло силой взрыва
        }
    }*/

    public void takeCover(Cover cover) {
        this.cover = cover;
    }
}
