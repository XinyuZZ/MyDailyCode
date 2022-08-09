package com.review;

public class Loan {
    private double rate;
    private double totalAmount;

    public Loan(double rate, double totalAmount) {
        this.rate = rate;
        this.totalAmount = totalAmount;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
