package com.prog34;

import com.prog34.entries.HouseDoor;
import com.prog34.places.*;
import com.prog34.entries.Entry;

public class World {
    public DayPhase dayPhase = DayPhase.NIGHT;

    public World() {
        // В конструкторе можно создать всё, а в startAction() уже запускать,
        // хотя тогда будет много полей, где хранить созданные объекты

    }

    public void startAction() {

        // создать космический городок (или world = городок?)
        Hangar hangar = new Hangar(); // поместить как-то в городок
        Rocket rocket = new Rocket(); // поместить (!РЯДОМ С АНГАРОМ???) как-то в городок
        House house = new House("дом"); // поместить как-то в городок
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
        Shorty[] shorties = new Shorty[7];
        shorties[0] = zvezdochkin;
        shorties[1] = znaika;

        Cover blanket = new Blanket("одеяло");
        // Поместить как-то одеяло в комнату (дом)

        zvezdochkin.sleepIn(house); // Спит в доме (комнате)
        rocket.explode();
        zvezdochkin.fallIn(house.getFloor());
        clep.injure("из-за взрыва ракеты");
        // Звездочкин оказывается на полу
        znaika.takeCover(blanket); // Знайка укутывается в одеяло
        znaika.goToPlace(houseDoor); // Реализовать перемещение через энтрипоинты между плэйсами
        znaika.lookAt(hangar);

        YardAreaAroundCabineTransition yardAreaAroundCabineTransition = new YardAreaAroundCabineTransition(yard, hangar.getAreaAroundHangar());
        OutsideAreaAroundCabineTransition outsideTransition = new OutsideAreaAroundCabineTransition(outside, hangar.getAreaAroundHangar());
        AreasAroundHangarAndCabineTransition areasTransition = new AreasAroundHangarAndCabineTransition(hangar.getAreaAroundHangar(), rocket.getAreaAroundCabine());

        znaika.goToPlace(yardAreaAroundCabineTransition);

        zvezdochkin.goToPlace(yardAreaAroundCabineTransition);

        hangar.putOut();

        zvezdochkin.lookAt(hangar);
        znaika.lookAt(hangar);




        shorties[2] = fuxy;
        shorties[3] = seld;
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

        clep.goToPlace(rocket.getIlluminators().get(0));
        rocket.getCabine().fixMotorByEngineer(clep);
        clep.goToPlace(rocket.getIlluminators().get(0));
        rocket.getAreaAroundCabine().openLockChamberDoorBy(clep);
    }

    class YardAreaAroundCabineTransition extends Entry {
        public YardAreaAroundCabineTransition(Yard yard, AreaAroundHangar area) {
            super("Со двора к ангару", true, yard, area);
            yard.addEntry(this);
            area.addEntry(this);
        }
    }
    class OutsideAreaAroundCabineTransition extends Entry {
        public OutsideAreaAroundCabineTransition(Outside outside, AreaAroundHangar area) {
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
