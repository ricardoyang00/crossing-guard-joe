package com.CrossingGuardJoe.model.game;

import com.CrossingGuardJoe.model.game.elements.Car;
import com.CrossingGuardJoe.model.game.elements.Joe;
import com.CrossingGuardJoe.model.game.elements.Kid;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoadBuilder {
    private final Random rand = new Random();
    public Road createRoad() {
        Road road = new Road();

        road.setJoe(createJoe());
        road.setKids(createKids());
        road.setCars(createCars());

        return road;
    }

    private Joe createJoe() {
        return new Joe(390, 297);
    }

    private List<Car> createCars() {
        List<Car> cars = new ArrayList<>();
        Random rand = new Random();

        int[] xValues = { 85, 172, 259, 346 };
        int randomIndex = rand.nextInt(xValues.length);
        int randomX = xValues[randomIndex];

        int randomY = -rand.nextInt(500);
        int intervalOffset = 250;

        for (int i = 0; i < 10; i++) {
            Car car = new Car(randomX, randomY);
            cars.add(car);
            randomX = xValues[rand.nextInt(xValues.length)];
            randomY -= (rand.nextInt(500) + intervalOffset);
        }
        return cars;
    }

    private List<Kid> createKids() {
        List<Kid> kids = new ArrayList<>();
        int x = 440;

        for (int i = 0; i < 1; i++) {
            Kid kid = new Kid(x, 330);
            kids.add(kid);
            x += 15;
        }
        return kids;
    }
}