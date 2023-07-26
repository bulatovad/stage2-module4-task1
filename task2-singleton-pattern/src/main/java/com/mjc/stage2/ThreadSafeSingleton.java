package com.mjc.stage2;

public class ThreadSafeSingleton {
    // Write your code here!
    private ThreadSafeSingleton instance = new ThreadSafeSingleton();
    private ThreadSafeSingleton() {
    }

    public ThreadSafeSingleton getInstance() {
        return instance;
    }
}
