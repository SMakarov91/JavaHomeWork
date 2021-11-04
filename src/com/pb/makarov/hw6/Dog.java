package com.pb.makarov.hw6;


import java.util.Objects;

public class Dog extends Animal{

    private int lifeSpan = 12;
    private String breed = "Овчарка";

    @Override
    public void makeNoise() {
        System.out.println("Собака гавкает");
    }

    @Override
    public void eat() {
        System.out.println("Собака ест");
    }

    @Override
    public void sleep() {
        System.out.println("Собака спит");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return lifeSpan == dog.lifeSpan && Objects.equals(breed, dog.breed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lifeSpan, breed);
    }

    @Override
    public String toString() {
        return "Dog{" +
                "lifeSpan=" + lifeSpan +
                ", breed='" + breed + '\'' +
                '}';
    }
}
