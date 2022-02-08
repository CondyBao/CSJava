package intro.bankAccount;

public class GreatAccount extends BankAccount{
    private int month = 0;
    private boolean withdrawed = false;
    private int withdraw_thisMonth = 0;

    public void withdraw(double amount) {
        if (withdraw_thisMonth > 2) {
            System.out.println("Withdraw Failed: Monthly withdrawal used up");
        }
        else {
            withdrawed = true;
            withdraw_thisMonth++;
            deposit(-amount);
        }
    }

    public void nextMonth() {
        month++;
        withdraw_thisMonth = 0;
        if (month != 0 && month % 12 == 0) {
            if (!withdrawed) deposit(getMoney());
            withdrawed = false;
        }
    }

    public GreatAccount(String name, int money) {
        super(name, money);
    }

    public static void main(String[] args) {
        BankAccount basicAccount = new BankAccount("condy", 1000);
        BankAccount basicAccount2 = new BankAccount("condy#2");
        InterestAccount interestAcc = new InterestAccount("condy#3", 100000, 0.2);
        CreditCard creditAcc = new CreditCard("condy#4", 1000, 0.4);
        GreatAccount greatAcc = new GreatAccount("condy#5", 100000);
        basicAccount.deposit(10000);
        basicAccount.withdraw(100);
        basicAccount2.deposit(1000);
        System.out.println(basicAccount);
        System.out.println(basicAccount2);
        interestAcc.deposit(1000);
        interestAcc.addInterest();
        System.out.println(interestAcc);
        creditAcc.addInterest();
        creditAcc.withdraw(1300);
        System.out.println(creditAcc);
        greatAcc.withdraw(10);
        greatAcc.withdraw(100);
        greatAcc.withdraw(1000);
        greatAcc.withdraw(10000);
        greatAcc.nextMonth();
        greatAcc.withdraw(10);
        for (int i = 0; i < 11; i++) {
            greatAcc.nextMonth();
        }
        System.out.println(greatAcc);
        for (int i = 0; i < 12; i++) {
            greatAcc.nextMonth();
        }
        System.out.println(greatAcc);
    }
}
