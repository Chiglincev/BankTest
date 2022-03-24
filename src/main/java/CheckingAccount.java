public class CheckingAccount extends Account {
    private int balance;

    @Override
    void addMoney(int amount) {
        balance += amount;
        System.out.println(amount + " пополнено. На счете " + balance + ".");
    }

    @Override
    void pay(int amount) {
        if (balance - amount >= 0) {
            balance -= amount;
            System.out.println(amount + " оплачено. На счете " + balance + ".");
        } else {
            System.out.println("Недостаточно средств на счёте.");
        }
    }

    @Override
    void transfer(Account account, int amount) {
        if (balance - amount >= 0) {
            try {
                account.addMoney(amount);
                balance -= amount;
                System.out.println(amount + " переведено. На счете " + balance + ".");
            } catch (NonValidOperation exception) {
                System.out.println("Недопустимая операция. Перевод не осуществлён.");
            }
        } else {
            System.out.println("Недостаточно средств на счёте.");
        }
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
