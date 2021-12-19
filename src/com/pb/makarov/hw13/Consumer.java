package com.pb.makarov.hw13;

public class Consumer implements Runnable {

    private final Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            buffer.get();
        }
    }
}
