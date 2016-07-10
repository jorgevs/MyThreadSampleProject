package com.jvs.test.threads.sync;

import java.util.logging.Level;
import java.util.logging.Logger;

class Processor extends Thread {

    //volatile is used to prevent threads caching variables when the variable is changed from another thread
    private volatile boolean running = true;
    
    @Override
    public void run() {
        while(running){
            System.out.println("Hello world thread: " + this.getId());            
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Processor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void shutdown(){
        this.running = false;
    }
}