package com.prog34;

import com.prog34.entries.HouseDoor;
import com.prog34.places.House;
import com.prog34.places.Yard;

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

        Shorty zvezdochkin = new Shorty("Звёздочкин", house);
        Shorty znaika = new Shorty("Знайка", house);
        Cover blanket = new Blanket("одеяло");
        // Поместить как-то одеяло в комнату (дом)

        zvezdochkin.sleepIn(house); // Спит в доме (комнате)
        hangar.crash(); // взрывается ангар!
        // Звездочкин оказывается на полу
        znaika.takeCover(blanket); // Знайка укутывается в одеяло
        znaika.goToPlace(houseDoor); // Реализовать перемещение через энтрипоинты между плэйсами

    }
}
