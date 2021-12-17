package com.pb.makarov.hw10;

public class NumBox<T extends Number> {

    private final T[] number;
    private int index;

    @SuppressWarnings("unchecked")
    public NumBox(int size) {
        number = (T[]) new Number[size];
    }

    void add(T t) throws Exception {
        if (index >= number.length) {
            throw new Exception("Массив уже заполнен!");
        }
        number[index] = t;
        index++;
    }

    public T get(int index) {
        return number[index];
    }

    public int length() {
        int j = 0;
        for (int i = 0; i < number.length; i++)
            if (number[i] != null) {
                j++;
            }
        return j;
    }

    public double average() {
        return sum() / length();
    }

    public double sum() {
        double sum = 0;
        for (int i = 0; i < number.length; i++) {
            if (number[i] != null) {
                sum += number[i].doubleValue();
            }
        }
        return sum;
    }

    public T max() {
        T max = number[0];
        for (int i = 0; i < number.length; i++) {
            if (number[i] != null && number[i].doubleValue() > max.doubleValue()) {
                max = number[i];
            }
        }
        return max;
    }
}
