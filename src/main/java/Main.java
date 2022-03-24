public class Main {
    public static void main(String[] args) {
        Account account = new SavingAccount();
        Account account1 = new CreditAccount();
        Account account2 = new CheckingAccount();

        addMoney(account,50_000);
        transferMoney(account, account2, 25_000);
        account.pay(5_000);
        System.out.println();

        transferMoney(account1, account,10_000);
        account1.pay(30_000);
        addMoney(account1,50_000);
        addMoney(account1,20_000);
        System.out.println();

        addMoney(account2,10_000);
        account2.pay(100_000);
        account2.pay(5_000);
        transferMoney(account2, account1, 20_000);
    }

    static void addMoney(Account account, int amount) {
        try {
            account.addMoney(amount);
        } catch (NonValidOperation exception) {
        }
    }

    static void transferMoney(Account accountOut, Account accountIn, int amount) {
        try {
            accountOut.transfer(accountIn, amount);
        } catch (NonValidOperation exception) {
        }
    }
}
