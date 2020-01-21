package com.prog34;

import com.prog34.Cover;
import com.prog34.HealthStatus;
import com.prog34.Visibility;
import com.prog34.entries.HouseDoor;
import com.prog34.lib.messageservice.MessageService;
import com.prog34.places.Place;
import com.prog34.entries.Entry;

public class Shorty {
    protected String name;
    protected HealthStatus health;
    protected Place currentPlace;
    protected Cover cover;

    public Shorty(String name, Place currentPlace) {
        this.name = name;
        this.currentPlace = currentPlace;
    }

    public void heal() {
        if (health == HealthStatus.INJURED)
            health = HealthStatus.UNHARMED;
    }

    public void sleepIn(Place place) {
        MessageService.showMessageWithNewLineEnding(this.name + " спит в " + this.currentPlace.getName() + "е");
    }

    public void goToPlace(Entry entry) {
        if (entry.IsEntryOpened()) {
            if (currentPlace.getEntries().contains(entry)) {
                this.currentPlace = entry.getPlace();
                MessageService.showMessageWithNewLineEnding(name + " переходит в локацию " + currentPlace.getName());
            } else {
                MessageService.showMessageWithNewLineEnding("Переход невозможен :(");
            }
        } else {
            MessageService.showMessageWithNewLineEnding(name + " пытается перейти в локацию " + currentPlace.getName() + ", но проход заблокирован :(");
        }
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
