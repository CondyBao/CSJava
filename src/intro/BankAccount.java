package intro;

public class BankAccount {
    String name;
    int money;
    double rate;

    public void deposit(int n) {
        money += n;
    }

    public void withdraw(int n) {
        money -= n;
    }

    public void addInterest() {
        money += money * rate;
    }

    public String toString() {
        return name + " has " + money + " dollars in the account";
    }

    public BankAccount(String name, int money, double rate) {
        this.name = name;
        this.money = money;
        this.rate = rate;
    }

    public BankAccount(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Condy", 10000000, 100);
        account1.deposit(1000);
        account1.withdraw(1);
        account1.addInterest();
        System.out.println(account1);
        BankAccount account2 = new BankAccount("anon", 100, -0.1);
        BankAccount account3 = new BankAccount("anon#2", -0.2);
    }
}
