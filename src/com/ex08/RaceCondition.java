/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ex08;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author vanting
 */
class NonAtomicNum {

    // read and write are atomic
    private int value;

    public NonAtomicNum(int v) {
        this.value = v;
    }

    public int get() {
        return value;
    }

    // but increment and decrement are not atomic if not sync
    public int incrementAndGet() {
        return ++value;
    }

    public int decrementAndGet() {
        return --value;
    }

    
//    public synchronized int incrementAndGet() {
//        return ++value;
//    }
//    
//    public synchronized int decrementAndGet() {
//        return --value;
//    }
    
}

class RaceTask implements Runnable {

    private boolean isIncrement;
    
    public RaceTask setIncrement() {
        isIncrement = true;
        return this;
    }
    
    public RaceTask setDecrement() {
        isIncrement = false;
        return this;
    }

    @Override
    public void run() {
        if (isIncrement) {
            for (int i = 0; i < 10000; i++) {
                RaceCondition.num.incrementAndGet();
            }
        } else {
            for (int i = 0; i < 10000; i++) {
                RaceCondition.num.decrementAndGet();
            }
        }
    }
}

public class RaceCondition {

    public static NonAtomicNum num = new NonAtomicNum(0);
    //public static AtomicInteger num = new AtomicInteger(0);

    public static void main(String[] args) {

        Thread increment = new Thread(new RaceTask().setIncrement());
        Thread decrement = new Thread(new RaceTask().setDecrement());

        increment.start();
        decrement.start();

        /*
         * wait both threads to finish
         */
        try {
            increment.join();
            decrement.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // the expected output should be zero
        System.out.println(num.get());
    }

}
