package com.pb.makarov.hw7;

public class Skirt extends Clothes implements WomenClothes {
    public Skirt(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressWomen() {
        System.out.println("Юбка: " + getSize() + ", " + getSize().getDescription() + " " + getSize().getEuroSize()
                + ", стоимость " + getPrice() + ", цвет " + getColor());
    }
}
