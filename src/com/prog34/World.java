package com.prog34;

import com.prog34.entries.HouseDoor;
import com.prog34.entries.Illuminator;
import com.prog34.entries.LockChamberDoor;
import com.prog34.exceptions.EntryNotInPlaceException;
import com.prog34.lib.messageservice.MessageService;
import com.prog34.places.*;
import com.prog34.entries.Entry;

import java.util.ArrayList;

public class World {
    public DayPhase dayPhase = DayPhase.NIGHT;

    public void startAction() {
        try {

            Hangar hangar = new Hangar();
            Rocket rocket = new Rocket();
            House house = new House("дом");
            Yard yard = new Yard("двор");
            HouseDoor houseDoor = new HouseDoor(house, yard);
            Outside outside = new Outside();

            rocket.connect(hangar);

            house.addHouseDoor(houseDoor);

            Shorty zvezdochkin = new Shorty("Звёздочкин", house);
            Shorty znaika = new Shorty("Знайка", house);
            Shorty fuxy = new Shorty("Фуксия", outside);
            Shorty seld = new Shorty("Селедочка", outside);
            ShortyEngineer clep = new ShortyEngineer("Клепка", outside);
            ArrayList<Shorty> shorties = new ArrayList<>();
            shorties.add(zvezdochkin);
            shorties.add(znaika);

            Cover blanket = new Blanket("одеяло");

            zvezdochkin.sleepIn(house);
            rocket.explode();
            zvezdochkin.fallIn(house.getFloor());
            clep.injure("из-за взрыва ракеты");
            znaika.takeCover(blanket);
            houseDoor.openBy(znaika);
            znaika.goToPlace(houseDoor);
            znaika.lookAt(hangar);

            YardAreaAroundCabineTransition yardAreaAroundCabineTransition = new YardAreaAroundCabineTransition(yard, hangar.getAreaAroundHangar());
            OutsideAreaAroundAngarTransition outsideTransition = new OutsideAreaAroundAngarTransition(outside, hangar.getAreaAroundHangar());
            AreasAroundHangarAndCabineTransition areasTransition = new AreasAroundHangarAndCabineTransition(hangar.getAreaAroundHangar(), rocket.getAreaAroundCabine());

            zvezdochkin.goToPlace(houseDoor);

            znaika.goToPlace(yardAreaAroundCabineTransition);

            zvezdochkin.goToPlace(yardAreaAroundCabineTransition);

            hangar.putOut();

            zvezdochkin.lookAt(hangar);
            znaika.lookAt(hangar);

            shorties.add(fuxy);
            shorties.add(seld);
            fuxy.goToPlace(outsideTransition);
            seld.goToPlace(outsideTransition);

            hangar.getAreaAroundHangar().clearPlaceBy(shorties);
            this.dayPhase = DayPhase.MORNING;

            fuxy.goToPlace(areasTransition);
            seld.goToPlace(areasTransition);

            rocket.getAreaAroundCabine().openLockChamberDoorBy(fuxy);
            rocket.getAreaAroundCabine().openLockChamberDoorBy(seld);

            clep.heal();
            clep.goToPlace(outsideTransition);
            clep.goToPlace(areasTransition);

            Illuminator illum0 = rocket.getIlluminators().get(0);

            clep.goToPlace(illum0);
            rocket.getCabine().fixMotorByEngineer(clep);
            clep.goToPlace(illum0);
            rocket.getAreaAroundCabine().openLockChamberDoorBy(clep);

            zvezdochkin.goToPlace(areasTransition);
            znaika.goToPlace(areasTransition);

            LockChamberDoor door = rocket.getAreaAroundCabine().getDoor();

            for (Shorty anotherShorty : shorties) {
                anotherShorty.goToPlace(door);
                Spacesuit spacesuit = rocket.getCabine().takeSpacesuitByShorty(anotherShorty);
                anotherShorty.goToPlace(door);

                anotherShorty.dropCargo();
                spacesuit.checkByShorty(anotherShorty);
            }
        } catch (EntryNotInPlaceException e) {
            MessageService.showMessageWithNewLineEnding("Переход невозможен :(");
            MessageService.showMessageWithNewLineEnding(e.getMessage());
        }
    }

    class YardAreaAroundCabineTransition extends Entry {
        public YardAreaAroundCabineTransition(Yard yard, AreaAroundHangar area) {
            super("Со двора к ангару", true, yard, area);
            yard.addEntry(this);
            area.addEntry(this);
        }
    }

    class OutsideAreaAroundAngarTransition extends Entry {
        public OutsideAreaAroundAngarTransition(Outside outside, AreaAroundHangar area) {
            super("Из вечной мерзлоты к ангару", true, outside, area);
            outside.addEntry(this);
            area.addEntry(this);
        }
    }

    class AreasAroundHangarAndCabineTransition extends Entry {
        public AreasAroundHangarAndCabineTransition(AreaAroundHangar hangarArea, AreaAroundCabine cabineArea) {
            super("От дымящихся обломков к кабине", true, hangarArea, cabineArea);
            hangarArea.addEntry(this);
            cabineArea.addEntry(this);
        }
    }

}
