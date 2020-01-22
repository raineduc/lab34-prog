package com.prog34;

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
    protected Cargo cargo;

    public Shorty(String name, Place currentPlace) {
        this.name = name;
        this.currentPlace = currentPlace;
    }

    public void heal() {
        if (health == HealthStatus.INJURED) {
            health = HealthStatus.UNHARMED;
            MessageService.showMessageWithNewLineEnding(name + " оправился");
        }
    }

    public void injure(String reason) {
        MessageService.showMessageWithNewLineEnding(name + " ранен из-за " + reason);
        health = HealthStatus.INJURED;
    }

    public void sleepIn(Place place) {
        this.sleep = true;
        MessageService.showMessageWithNewLineEnding(this.name + " спит в " + this.currentPlace.getName() + "е");
    }

    public void fallIn(Surface surface) {
        MessageService.showMessageWithNewLineEnding(name + " падает на " + surface.getName());
    }

    public void goToPlace(Entry entry) {

        Place destination = (entry.getPlace1() == currentPlace) ? entry.getPlace2() : entry.getPlace1();
        Place departure = (entry.getPlace1() == destination) ? entry.getPlace2() : entry.getPlace1();
        if (currentPlace.getEntries().contains(entry)) {
            if (entry.IsEntryOpened()) {
                this.currentPlace = destination;
                MessageService.showMessageWithNewLineEnding(name + " переходит в локацию " + destination.getName());
                if (this.cargo != null) {
                    MessageService.showMessageWithNewLineEnding(name + " также проносит с собой " + cargo.getName());
                }
            } else {
                MessageService.showMessageWithNewLineEnding(name + " пытается перейти в локацию " + destination.getName() + ", но проход заблокирован :(");
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

    public void takeCargo(Cargo cargo) {
        this.cargo = cargo;
        MessageService.showMessageWithNewLineEnding(name + " взял с собой " + cargo.getName());
    }

    public Cargo dropCargo() {
        Cargo savedCargo = cargo;
        MessageService.showMessageWithNewLineEnding(name + " сбрасывает " + cargo.getName());
        this.cargo = null;
        return savedCargo;
    }

    public Place getCurrentPlace() {
        return currentPlace;
    }

    public String getName() {
        return this.name;
    }
}
