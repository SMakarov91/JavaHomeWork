package com.pb.makarov.hw7;

public class Tie extends Clothes implements ManClothes {
    public Tie(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void dressMan() {
        System.out.println("Галстук: " + getSize() + ", " + getSize().getDescription() + " " + getSize().getEuroSize()
                + ", стоимость " + getPrice() + ", цвет " + getColor());
    }
}
