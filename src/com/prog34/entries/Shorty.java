package com.prog34.entries;

import com.prog34.entries.Cover;
import com.prog34.entries.HealthStatus;
import com.prog34.entries.Visibility;
import com.prog34.entries.lib.messageservice.MessageService;
import com.prog34.entries.places.Place;
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
        MessageService.showMessageWithNewLineEnding(this.name + " закутался в " + cover.getCoverName());
    }
}
