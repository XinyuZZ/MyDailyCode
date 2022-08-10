<<<<<<< HEAD
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ex08;

/**
 * Run three threads to print 0 to 299.
 * 
 * @author vanting
 */
public class ThreadSwitching {

    public static void main(String[] args) {
        
        MySwitchingThread t1 = new MySwitchingThread(0, 3, 300);
        MySwitchingThread t2 = new MySwitchingThread(1, 3, 300);
        MySwitchingThread t3 = new MySwitchingThread(2, 3, 300);

        t1.start();
        t2.start();
        t3.start();
    }
}

class MySwitchingThread extends Thread {

    private int startIdx, nThreads, maxIdx;

    public MySwitchingThread(int s, int n, int m) {
        this.startIdx = s;
        this.nThreads = n;
        this.maxIdx = m;
    }

    @Override
    public void run() {
        for (int i = this.startIdx; i < this.maxIdx; i += this.nThreads) {
            System.out.println("[ID " + this.getId() + "] " + i);
        }
    }
}
=======
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ex08;

/**
 * Run three threads to print 0 to 299.
 * 
 * @author vanting
 */
public class ThreadSwitching {

    public static void main(String[] args) {
        
        MySwitchingThread t1 = new MySwitchingThread(0, 3, 300);
        MySwitchingThread t2 = new MySwitchingThread(1, 3, 300);
        MySwitchingThread t3 = new MySwitchingThread(2, 3, 300);

        t1.start();
        t2.start();
        t3.start();
    }
}

class MySwitchingThread extends Thread {

    private int startIdx, nThreads, maxIdx;

    public MySwitchingThread(int s, int n, int m) {
        this.startIdx = s;
        this.nThreads = n;
        this.maxIdx = m;
    }

    @Override
    public void run() {
        for (int i = this.startIdx; i < this.maxIdx; i += this.nThreads) {
            System.out.println("[ID " + this.getId() + "] " + i);
        }
    }
}
>>>>>>> 13eedf8f55122829bb6e261a489d63bcd721fa8e
