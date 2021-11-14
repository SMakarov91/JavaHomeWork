package com.pb.makarov.hw7;

public class Pants extends Clothes implements ManClothes, WomenClothes {

    public Pants(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Штаны: " + getSize() + ", " + getSize().getDescription() + " " + getSize().getEuroSize()
                + ", стоимость " + getPrice() + ", цвет " + getColor());
    }

    @Override
    public void dressWomen() {
        System.out.println("Штаны: " + getSize() + ", " + getSize().getDescription() + " " + getSize().getEuroSize()
                + ", стоимость " + getPrice() + ", цвет " + getColor());
    }
}
