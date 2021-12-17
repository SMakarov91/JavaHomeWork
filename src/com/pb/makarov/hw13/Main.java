package com.pb.makarov.hw13;

public class Main {

    public static void main(String[] args) {

        Buffer buffer = new Buffer();
        Producer producer = new Producer(buffer);
        Consumer consumer = new Consumer(buffer);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}


