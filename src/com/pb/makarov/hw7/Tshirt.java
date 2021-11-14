package com.pb.makarov.hw7;

public class Tshirt extends Clothes implements ManClothes, WomenClothes {

    public Tshirt(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Футболка: " + getSize() + ", " + getSize().getDescription() + " " + getSize().getEuroSize()
                + ", стоимость " + getPrice() + ", цвет " + getColor());
    }

    @Override
    public void dressWomen() {
        System.out.println("Футболка: " + getSize() + ", " + getSize().getDescription() + " " + getSize().getEuroSize()
                + ", стоимость " + getPrice() + ", цвет " + getColor());
    }
}
