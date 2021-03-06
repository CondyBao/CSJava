package intro.bankAccount;

public class InterestAccount extends BankAccount{
    private double interestRate;

    public void addInterest() {
        deposit(getMoney() * interestRate);
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String toString() {
        return name + " has " + getMoney() + " in the account, and the interest rate for this account is " + interestRate + ".";
    }

    public InterestAccount(String name, int money, double interestRate) {
        super(name, money);
        this.interestRate = interestRate;
    }
}
