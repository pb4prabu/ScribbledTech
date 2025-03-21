package com.scribbledtech.java1to4;

/**
 * Hello world!
 */
public class ThreadExample extends Thread {
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
    }
    public static void main(String[] args) {
        ThreadExample t1 = new ThreadExample();
        System.out.println("Starting a new thread from main thread "+ Thread.currentThread().getName());
        t1.start();

    }

}
