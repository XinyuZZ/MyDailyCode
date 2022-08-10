package jensen.Lab6;

class AssertionDemo {
    private static int balance = 900;
    public static void main(String args[]) {
        System.out.println("Acc balance: " + withdrawMoney(500));
        System.out.println("Acc balance: " + withdrawMoney(500));
    }
    public static double withdrawMoney(double amount) {
// precondition: the balance must be enough for the withdraw amount
        assert balance >= amount; // when balance is enough
        balance -= amount;
        return balance;
    }
}