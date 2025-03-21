package com.scribbledtech.java1to4;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {


        Counter counter = new Counter();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) counter.increment();
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Final count: " + counter.count);
    }

}

class Counter {
    public int count = 0;

    public int increment() {
        return ++count;
    }
}