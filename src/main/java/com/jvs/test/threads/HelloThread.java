package com.jvs.test.threads;

import java.util.logging.Level;
import java.util.logging.Logger;

public class HelloThread extends Thread {

    @Override
    public void run() {
        for(int i=0; i<10; i++){
            System.out.println("Hello world thread: " + this.getId());
            PrintInfo.cheers();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(HelloThread.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

class PrintInfo {
    public static int cheers(){
        int value = 0;
        for (int i = 0; i < 10; i++) {
            value++;
        }        
        System.out.println("value: " + value);        
        return value;
    }
    
    //END
}

//end
