package com.pb.makarov.hw6;


import java.lang.reflect.Constructor;

public class VetСlinic {
    public static void main(String[] args) throws Exception {
        Dog dog = new Dog();
        dog.setFood("Мясо");
        dog.setLocation("будка");

        Cat cat = new Cat();
        cat.setFood("Молочко");
        cat.setLocation("дом");

        Horse horse = new Horse();
        horse.setFood("Сено");
        horse.setLocation("конюшня");

        Animal[] animals = new Animal[]{dog, cat, horse};

        Class vetClazz = Class.forName("com.pb.makarov.hw6.Veterinarian");
        Constructor constr = vetClazz.getConstructor();
        Object obj = constr.newInstance();

        for (Animal animal : animals) {
            if (obj instanceof Veterinarian) {
                ((Veterinarian) obj).treatAnimal(animal);
            }
        }

    }
}
