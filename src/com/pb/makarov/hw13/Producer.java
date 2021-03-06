package com.pb.makarov.hw13;

public class Producer implements Runnable {

    private final Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            buffer.put();
        }
    }
}
