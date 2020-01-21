package com.prog34;

import com.prog34.Cover;
import com.prog34.HealthStatus;
import com.prog34.Visibility;
import com.prog34.entries.HouseDoor;
import com.prog34.lib.messageservice.MessageService;
import com.prog34.places.Place;
public class Shorty {
    protected String name;
    protected HealthStatus health;
    protected Place currentPlace;
    protected Cover cover;
    protected boolean sleep = false;

    public Shorty(String name, Place currentPlace) {
        this.name = name;
        this.currentPlace = currentPlace;
    }

    public void heal() {
        if (health == HealthStatus.INJURED)
            health = HealthStatus.UNHARMED;
    }

    public void sleepIn(Place place) {
        this.sleep = true;
        MessageService.showMessageWithNewLineEnding(this.name + " спит в " + this.currentPlace.getName() + "е");
    }

    public void goToPlace(Place place) {
        // СРОЧНО РЕАЛИЗОВАТЬ ВОЗМОЖНОСТЬ ПЕРЕХОДОВ!!!
    }

    public void lookAt(Visibility object) {
        MessageService.showMessageWithNewLineEnding(this.name + " увидел " + object.getVisibilityInfo());
    }

    public void takeCover(Cover cover) {
        this.cover = cover;
        MessageService.showMessageWithNewLineEnding(this.name + " закутался в " + cover.getCoverName());
    }

    public String getName() {
        return this.name;
    }
}
