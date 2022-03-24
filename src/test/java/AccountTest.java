import org.junit.jupiter.api.*;

public class AccountTest {

    static CreditAccount creditAccount = new CreditAccount();
    static SavingAccount savingAccount = new SavingAccount();
    static CheckingAccount checkingAccount = new CheckingAccount();

    @BeforeAll
    public static void beforeAllMethod(){
    }

    @BeforeEach
    public void beforeEachMethod() {
        creditAccount.setBalance(-40_000);
        savingAccount.setBalance(50_000);
        checkingAccount.setBalance(50_000);
    }

    @AfterEach
    public void afterEachMethod() {
        System.out.println("_________________");
    }

    @AfterAll
    public static void afterAllMethod(){
    }

    @org.junit.jupiter.api.Test
    public void test_addMoney_success() {
        // given:
        int money = 20_000;
        int result;

        // when:
        creditAccount.addMoney(money);
        result = creditAccount.getBalance();
        boolean expectedCreditAccount = result <= 0;

        savingAccount.addMoney(money);
        result = savingAccount.getBalance();
        boolean expectedSavingAccount = result >= 0;

        checkingAccount.addMoney(money);
        result = checkingAccount.getBalance();
        boolean expectedCheckingAccount = result >= 0;


        // then:
        Assertions.assertTrue(expectedCreditAccount && expectedSavingAccount && expectedCheckingAccount);
    }

    @org.junit.jupiter.api.Test
    public void test_pay_success() {
        //given
        int money = 30_000;
        int result;

        //when
        creditAccount.pay(money);
        result = creditAccount.getBalance();
        boolean expextedCreditAccount = result <= 0;

        savingAccount.pay(money);
        result = savingAccount.getBalance();
        boolean expectedSavingAccount = result >= 0;

        checkingAccount.pay(money);
        result = checkingAccount.getBalance();
        boolean expectedCheckingAccount = result >= 0;

        //then
        Assertions.assertTrue(expectedSavingAccount && expextedCreditAccount && expectedCheckingAccount);
    }

    @org.junit.jupiter.api.Test
    public void test_transfer_success() {
        //given
        int startMoneySavingAccount = savingAccount.getBalance();
        int startMoneyCheckingAccount = checkingAccount.getBalance();
        int finallyMoneySavingAccount = savingAccount.getBalance();
        int finallyMoneyCheckingAccount = checkingAccount.getBalance();
        int money = 30_000;
        int result;

        //when
        try {
            savingAccount.transfer(creditAccount, money);
        } catch (NonValidOperation exception) {
            finallyMoneySavingAccount = savingAccount.getBalance();
        }
        result = savingAccount.getBalance();
        boolean expectedSavingAccount = result >= 0;

        try {
            checkingAccount.transfer(creditAccount, money);
        } catch (NonValidOperation exception) {
            finallyMoneyCheckingAccount = checkingAccount.getBalance();
        }
        result = checkingAccount.getBalance();
        boolean expectedCheckingAccount = result >= 0;

        //then
        Assertions.assertEquals(startMoneyCheckingAccount, finallyMoneyCheckingAccount);
        Assertions.assertEquals(startMoneySavingAccount, finallyMoneySavingAccount);
        Assertions.assertTrue(expectedSavingAccount && expectedCheckingAccount);
    }

    @org.junit.jupiter.api.Test
    public void test_nonValidOperation() throws NonValidOperation {
        //given
        int money = 60_000;
        int result;

        //when

        //then
        Assertions.assertThrows(NonValidOperation.class, () -> creditAccount.addMoney(money));
    }

}
