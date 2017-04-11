package com.jvs.test.threads;

public class App {
    
    public static void main(String[] args) {
        HelloThread thread1 = new HelloThread();
        HelloThread thread2 = new HelloThread();
        
        Thread runnable1 = new Thread(new HelloRunnable());
        Thread runnable2 = new Thread(new HelloRunnable());
        
        thread1.start();
        thread2.start();
        
        runnable1.start();
        runnable2.start();
    }
    
    //End
}
