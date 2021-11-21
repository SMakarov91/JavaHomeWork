package com.pb.makarov.hw7;
//e
public class Atelier {

    public static void main(String[] args) {

        Clothes tshirt = new Tshirt(Size.XXS, 200, "красный");
        Clothes pants = new Pants(Size.S, 550, "синий");
        Clothes skirt = new Skirt(Size.M, 450, "черный");
        Clothes tie = new Tie(Size.L, 250, "зеленый");

        Clothes[] clothes = new Clothes[]{tshirt, pants, skirt, tie};
        dressMan(clothes);
        dressWomen(clothes);
    }

    public static void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда:");
        for (Clothes cl : clothes) {
            if (cl instanceof ManClothes) {
                ManClothes manClothes = (ManClothes) cl;
                manClothes.dressMan();
            }
        }
        System.out.println();
    }

    public static void dressWomen(Clothes[] clothes) {
        System.out.println("Женская одежда:");
        for (Clothes cl : clothes) {
            if (cl instanceof WomenClothes) {
                WomenClothes womenClothes = (WomenClothes) cl;
                womenClothes.dressWomen();
            }
        }
        System.out.println();
    }
}
