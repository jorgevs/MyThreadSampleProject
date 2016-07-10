package com.jvs.test.threads.syncword;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SyncWordApp {
    private int count = 0;

    public static void main(String[] args) {       
        SyncWordApp syncWordApp = new SyncWordApp();
        syncWordApp.doWork();
    }

    public void doWork(){
        Thread t1 = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });
        Thread t2 = new Thread(new Runnable(){
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    increment();
                }
            }
        });

        t1.start();
        t2.start();
        
        //The join() method waits until a thread has completed its job. In this example, 
        //the principal will wait until t1 and t2 have finished.
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SyncWordApp.class.getName()).log(Level.SEVERE, null, ex);
        }
     
        System.out.println("Count value: " + count);
    }
    
    public synchronized void increment(){
        count++;
    }
    
}
