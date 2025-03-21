package com.scribbledtech.java1to4;

public class RunnableExample implements Runnable{
    public void run() {
        System.out.println("Thread " + Thread.currentThread().getName() + " is running...");
    }
    public static void main(String[] args) {
        RunnableExample myTask = new RunnableExample(); // Create a Runnable object
        Thread t1 = new Thread(myTask);  // Pass it to a Thread instance
        System.out.println("Starting a new thread from thread "+ Thread.currentThread().getName());
        t1.start(); // Start the thread
        Thread t2 = new Thread(myTask);  // Create another thread with same instance
        System.out.println("Starting a second thread from thread "+ Thread.currentThread().getName());
        t2.start(); // Start the second thread
    }
}
