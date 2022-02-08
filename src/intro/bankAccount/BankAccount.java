package intro.bankAccount;

public class BankAccount {
    String name;
    double money;

    public String getName() {
        return name;
    }

    public void deposit(double n) {
        money += n;
    }

    public void withdraw(double n) {
        money -= n;
    }

    public String toString() {
        return name + " has " + money + " dollars in the account";
    }

    public double getMoney() {
        return money;
    }

    public BankAccount(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public BankAccount(String name) {
        this.name = name;
        this.money = 0;
    }
}
