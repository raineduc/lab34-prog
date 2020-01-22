package com.prog34;

import com.prog34.Cover;
import com.prog34.HealthStatus;
import com.prog34.Visibility;
import com.prog34.entries.HouseDoor;
import com.prog34.lib.messageservice.MessageService;
import com.prog34.places.Place;
import com.prog34.entries.Entry;
import com.prog34.surfaces.Surface;

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

    public void fallIn(Surface surface) {
        MessageService.showMessageWithNewLineEnding(name + " падает на " + surface.getName());
    }

    public void goToPlace(Entry entry) {

        Place destination = (entry.getPlace1() == currentPlace) ? entry.getPlace1() : entry.getPlace2();
        Place departure = (entry.getPlace1() == destination) ? entry.getPlace2() : entry.getPlace1();
        if (currentPlace.getEntries().contains(entry)) {
            if (entry.IsEntryOpened()) {
                this.currentPlace = destination;
                MessageService.showMessageWithNewLineEnding(name + " переходит в локацию " + destination.getName());
            } else {
                MessageService.showMessageWithNewLineEnding(name + " пытается перейти в локацию " + currentPlace.getName() + ", но проход заблокирован :(");
            }
        } else {
            MessageService.showMessageWithNewLineEnding("Переход невозможен :(");
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
