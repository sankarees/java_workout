package org.computerg;
/**
 * Title: Lambda Threads Example in Java 8
 * Author: Sankareeswaran Alagarsamy
 * Document: Refer 'README.md' fpr more details
 */

import java.util.Date;

public class LambdaThreadsExample {
    public static void main(String[] args) {
        System.out.println("Main started: " + new Date());
        // Thread 1 (Job 1): Prints start time, sleeps 1 minute, prints end time
        Thread t1 = new Thread(() -> {
            int waitTime = 60 * 1000;
            System.out.println("Job1 started: " + new Date());
            try {
                System.out.println("Job1 wait for " + waitTime);
                Thread.sleep(waitTime); // 60,000 milliseconds = 1 minute
            } catch (InterruptedException exp) {
                System.out.println(exp.getMessage());
            }
            System.out.println("Job1 end time: " + new Date());
        });

        // Thread 2 (Job 2): Prints time after t1 completes
        Thread t2 = new Thread(() -> {
            System.out.println("Job2 waited till job1 get completed. Job2 started time: " + new Date());
        });
        try {
            t1.start();   // Start Thread 1
            t1.join();    // Wait for t1 to complete
            t2.start();   // Then start Thread 2
        } catch (InterruptedException exp) {
            System.out.println(exp.getMessage());
        }
        System.out.println("Main ended: " + new Date());
    }
}