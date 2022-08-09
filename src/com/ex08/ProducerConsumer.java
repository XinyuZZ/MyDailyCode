/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ex08;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vanting
 */
public class ProducerConsumer {

    public static Account account = new Account(0);

    public static void main(String[] args) {

        Thread producer = new Thread(new PCTask().setDeposit());
        Thread consumer = new Thread(new PCTask().setWithdraw());

        producer.start();
        consumer.start();
    }

}

class Account {

    private int balance;

    private ReentrantLock lock = new ReentrantLock();   // Create a new lock
    private Condition newDeposit = lock.newCondition();     // Create a condition

    public Account(int v) {
        this.balance = v;
    }

    public int get() {
        return balance;
    }

    public int depositAndGet() {
        lock.lock();
        int amount = (int) (Math.random() * 50) + 1;
        balance += amount;
        System.out.println("Balance: " + balance + " (+" + amount + ")");
        try {
            newDeposit.signalAll();
        } finally {
            lock.unlock();
        }
        return balance;
    }

    public int withdrawAndGet() {
        lock.lock();
        int amount = (int) (Math.random() * 10) + 1;
        try {
            while (balance < amount) {
                System.out.println("Not enough balance. Release lock and wait.");
                newDeposit.await();
                System.out.println("Re-acquire lock and check balance again.");
            }
            balance -= amount;
            System.out.println("Balance: " + balance + " (-" + amount + ")");
        } catch (InterruptedException ex) {
            Logger.getLogger(Account.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            lock.unlock();
        }
        return balance;
    }
}

class PCTask implements Runnable {

    private boolean isDeposit;

    public PCTask setDeposit() {
        isDeposit = true;
        return this;
    }

    public PCTask setWithdraw() {
        isDeposit = false;
        return this;
    }

    @Override
    public void run() {
        if (isDeposit) {
            while (true) {
                ProducerConsumer.account.depositAndGet();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PCTask.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            while (true) {
                try {
                    // this thread run 10x faster
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(PCTask.class.getName()).log(Level.SEVERE, null, ex);
                }
                ProducerConsumer.account.withdrawAndGet();
            }
        }
    }
}
