package com.jvs.test.threads.sync;

import java.util.Scanner;

public class App1 {
    public static void main(String[] args){
        Processor proc1 = new Processor();
        proc1.start();
        
        System.out.println("Press return to stop the thread...");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
        
        proc1.shutdown();
    }      
}
