package intro.bankAccount;

public class CreditCard extends InterestAccount {
    public void addInterest() {
        double depositAmount = getMoney() * getInterestRate();
        deposit(depositAmount - 10);
    }

    public void withdraw(double n) {
        if (getMoney() - n < 100) {
            System.out.println("Withdraw Failed: Insufficient Balance");
        }
        else deposit(-n);
    }

    public CreditCard(String name, int money, double interestRate) {
        super(name, money, interestRate);
    }
}
