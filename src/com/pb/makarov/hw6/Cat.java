package com.pb.makarov.hw6;

import java.util.Objects;

public class Cat extends Animal{

    private boolean nightVision = true;
    private String color="grey";

    @Override
    public void makeNoise() {
        System.out.println("Кошка мяукает");
    }

    @Override
    public void eat() {
        System.out.println("Кошка ест");
    }

    @Override
    public void sleep() {
        System.out.println("Кошка спит");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return nightVision == cat.nightVision && Objects.equals(color, cat.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nightVision, color);
    }

    @Override
    public String toString() {
        return "Cat{" +
                "nightVision=" + nightVision +
                ", color='" + color + '\'' +
                '}';
    }
}
