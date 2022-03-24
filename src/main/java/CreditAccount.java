public class CreditAccount extends Account {
    private int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    void addMoney(int amount) {
        if (balance + amount <= 0) {
            balance += amount;
            System.out.println(amount + " внесено. На счете " + balance + ".");
        } else {
            System.out.println("Вносимая сумма больше кредитного остатка.");
            throw new NonValidOperation();
        }
    }

    @Override
    void pay(int amount) {
        balance -= amount;
        System.out.println(amount + " Оплачено. На счете " + balance + ".");
    }

    @Override
    void transfer(Account account, int amount) {
            System.out.println("Переводы запрещены");
    }

}
