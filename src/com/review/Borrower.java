package com.review;

public class Borrower extends Person {
    private Loan loan;

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;

    }

    public Borrower(Name name, Address address) {
        super(name, address);
    }

    public String toString() {
        return super.toString() + "\n" + loan.getRate() + "\n" + loan.getTotalAmount();
    }

    public static void main(String[] args) {


        Borrower borrower =new Borrower(new Name("Hello"), new Address("Feilao"));
        borrower.setLoan(new Loan(1,2));

        System.out.println(borrower.toString());

    }
}
