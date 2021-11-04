package com.pb.makarov.hw6;

import java.util.Objects;

public class Horse extends Animal{

    private int speed = 85;
    private String rewards = "1 место";
    private String usage = "Соревнования";

    @Override
    public void makeNoise() {
        System.out.println("Лошадка иго-го");
    }

    @Override
    public void eat() {
        System.out.println("Лошадка ест");
    }

    @Override
    public void sleep() {
        System.out.println("Лошадка спит");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Horse horse = (Horse) o;
        return speed == horse.speed && Objects.equals(rewards, horse.rewards) && Objects.equals(usage, horse.usage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(speed, rewards, usage);
    }

    @Override
    public String toString() {
        return "Horse{" +
                "speed=" + speed +
                ", rewards='" + rewards + '\'' +
                ", usage='" + usage + '\'' +
                '}';
    }
}
