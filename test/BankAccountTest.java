import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code BankAccount1Test}'s constructors and kernel
 * methods.
 *
 * @author Gloria Zhong
 *
 */
public abstract class BankAccountTest {

    /**
     * Invokes the appropriate {@code BankAccount} constructor for the
     * implementation under test and returns the result.
     *
     * @return the balance
     * @ensures constructorTest = 0
     */
    protected abstract BankAccount constructorTest(String first, String last,
            int pass);

    /**
     * Invokes the appropriate {@code BankAccount} constructor for the reference
     * implementation and returns the result.
     *
     * @return the new number
     * @ensures constructorRef = 0
     */
    protected abstract BankAccount constructorRef(String first, String last,
            int pass);

    /*
     * Tests of constructor
     */
    @Test
    public void testConstructor1() {
        /*
         * Set up variables and call method under test
         */
        BankAccount exp = this.constructorTest("Gloria", "Zhong", 123456);

        BankAccount actual = this.constructorRef("Gloria", "Zhong", 123456);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(exp, actual);
    }

    @Test
    public void testConstructor2() {
        /*
         * Set up variables and call method under test
         */
        BankAccount exp = this.constructorTest("Glena", "Zhong", 88888888);
        exp.add(300);

        BankAccount actual = this.constructorRef("Glena", "Zhong", 88888888);
        actual.add(300);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(exp, actual);
    }

    @Test
    public void testConstructor3() {
        /*
         * Set up variables and call method under test
         */
        BankAccount exp = this.constructorTest("Glynis", "Zhong", 1357999);
        exp.add(130.5);

        BankAccount actual = this.constructorRef("Glynis", "Zhong", 1357999);
        actual.add(130.5);
        /*
         * Assert that values of variables match expectations
         */
        assertEquals(exp, actual);
    }

    /*
     * ----------------------Kernel Test---------------------------------------
     */

    /*
     * Tests of subtract
     */
    @Test
    public void subtract1() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(100.0);
        test.subtract(0);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(100);

        assertEquals(test, exp);
    }

    @Test
    public void subtract2() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(1000.0);
        test.subtract(55.3);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(944.7);

        assertEquals(test, exp);
    }

    /*
     * Tests of subtract
     */
    @Test
    public void subtract3() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(9999999);
        test.subtract(58.96);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(9999940.04);

        assertEquals(test, exp);
    }

    /*
     * Tests of add
     */
    @Test
    public void add1() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(100.0);
        test.add(100);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(200);

        assertEquals(test, exp);
    }

    @Test
    public void add2() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(95.97);
        test.add(264);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(359.97);

        assertEquals(test, exp);
    }

    @Test
    public void add3() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(88888888.88);
        test.add(999.76);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(88889888.64);

        assertEquals(test, exp);
    }

    /*
     * Tests of checkPassWord
     */
    @Test
    public void checkPassWord1() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 1111111);
        boolean exp = true;
        boolean actual = test.checkPassWord(1111111);

        assertEquals(exp, actual);

    }

    @Test
    public void checkPassWord2() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        boolean exp = true;
        boolean actual = test.checkPassWord(123456);

        assertEquals(exp, actual);

    }

    @Test
    public void checkPassWord3() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 99999999);
        boolean exp = true;
        boolean actual = test.checkPassWord(99999999);

        assertEquals(exp, actual);

    }

    /*
     * Tests of checkFirstName
     */
    @Test
    public void checkFirstName1() {
        BankAccount test = new BankAccount1("a", "b", 1111111);
        boolean exp = true;
        boolean actual = test.checkFirstName("a");

        assertEquals(exp, actual);

    }

    @Test
    public void checkFirstName2() {
        BankAccount test = new BankAccount1("abcde", "b", 1111111);
        boolean exp = true;
        boolean actual = test.checkFirstName("abcde");

        assertEquals(exp, actual);

    }

    @Test
    public void checkFirstName3() {
        BankAccount test = new BankAccount1("ab12345", "b", 1111111);
        boolean exp = true;
        boolean actual = test.checkFirstName("ab12345");

        assertEquals(exp, actual);

    }

    /*
     * Tests of checkLastName
     */
    @Test
    public void checkLastName1() {
        BankAccount test = new BankAccount1("a", "b", 1111111);
        boolean exp = true;
        boolean actual = test.checkLastName("b");

        assertEquals(exp, actual);

    }

    public final void checkLastName2() {
        BankAccount test = new BankAccount1("a", "abcd", 1111111);
        boolean exp = true;
        boolean actual = test.checkLastName("abcd");

        assertEquals(exp, actual);

    }

    public final void checkLastName3() {
        BankAccount test = new BankAccount1("a", "abc123", 1111111);
        boolean exp = true;
        boolean actual = test.checkLastName("abc123");

        assertEquals(exp, actual);

    }

    /*
     * Tests of firstName
     */
    @Test
    public void firstName1() {
        BankAccount test = new BankAccount1("a", "a", 1111111);
        String exp = "a";
        String actual = test.firstName();

        assertEquals(exp, actual);

    }

    @Test
    public void firstName2() {
        BankAccount test = new BankAccount1("abc", "abc", 1111111);
        String exp = "abc";
        String actual = test.firstName();

        assertEquals(exp, actual);

    }

    @Test
    public void firstName3() {
        BankAccount test = new BankAccount1("cdb456", "cdb456", 1111111);
        String exp = "cdb456";
        String actual = test.firstName();

        assertEquals(exp, actual);

    }

    /*
     * Tests of lastName
     */
    @Test
    public void lastName1() {
        BankAccount test = new BankAccount1("a", "b", 1111111);
        String exp = "b";
        String actual = test.lastName();

        assertEquals(exp, actual);

    }

    @Test
    public void lastName2() {
        BankAccount test = new BankAccount1("abc", "abc", 1111111);
        String exp = "abc";
        String actual = test.lastName();

        assertEquals(exp, actual);

    }

    @Test
    public void lastName3() {
        BankAccount test = new BankAccount1("cdb456", "cdb456", 1111111);
        String exp = "cdb456";
        String actual = test.lastName();

        assertEquals(exp, actual);

    }

    /*
     * --------------------BankAccountSecondary---------------------------------
     *
     */

    /*
     * Tests of extract
     */
    @Test
    public void extract1() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(10);
        double returnTest = test.extract(5, 123456);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(5);
        double returnExp = 5;

        boolean balance = Math.abs(returnTest - returnExp) <= 0.009;

        assertEquals(test, exp);
        assertEquals(balance, true);

    }

    @Test
    public void extract2() {

        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(999999);
        double returnTest = test.extract(777, 123456);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(999222);
        double returnExp = 999222;

        boolean balance = Math.abs(returnTest - returnExp) <= 0.009;

        assertEquals(test, exp);
        assertEquals(balance, true);

    }

    @Test
    public void extract3() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(999999.99);
        double returnTest = test.extract(777.88, 123456);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(999222.11);
        double returnExp = 999222.11;

        boolean balance = Math.abs(returnTest - returnExp) <= 0.009;

        assertEquals(test, exp);
        assertEquals(balance, true);

    }

    /*
     * Tests of deposit
     */
    @Test
    public void deposit1() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(10);
        double returnTest = test.deposit(5);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(15);
        double returnExp = 15;

        boolean balance = Math.abs(returnTest - returnExp) <= 0.009;

        assertEquals(test, exp);
        assertEquals(balance, true);

    }

    @Test
    public void deposit2() {

        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(999999);
        double returnTest = test.deposit(777);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(1000776);
        double returnExp = 1000776;

        boolean balance = Math.abs(returnTest - returnExp) <= 0.009;

        assertEquals(test, exp);
        assertEquals(balance, true);

    }

    @Test
    public void deposit3() {
        BankAccount test = new BankAccount1("Gloria", "Zhong", 123456);
        test.add(999999.99);
        double returnTest = test.deposit(777.88);

        BankAccount exp = new BankAccount1("Gloria", "Zhong", 123456);
        exp.add(1000777.87);
        double returnExp = 1000777.87;

        boolean balance = Math.abs(returnTest - returnExp) <= 0.009;

        assertEquals(test, exp);
        assertEquals(balance, true);

    }

    /*
     * Tests of transfer
     */
    @Test
    public void transfer1() {
        BankAccount test = new BankAccount1("give", "to", 123456);
        BankAccount testReceive = new BankAccount1("receive", "receive",
                123456);

        test.add(5);
        double returnValue = test.transfer(5, testReceive, 123456);

        BankAccount exp = new BankAccount1("give", "to", 123456);
        double returnExp = 0;

        BankAccount expReceive = new BankAccount1("receive", "receive", 123456);
        expReceive.add(5);

        boolean returnCheck = Math.abs(returnValue - returnExp) <= 0.009;

        assertEquals(test, exp);
        assertEquals(testReceive, expReceive);

        assertEquals(returnCheck, true);

    }

    @Test
    public void transfer2() {
        BankAccount test = new BankAccount1("give", "to", 123456);
        BankAccount testReceive = new BankAccount1("receive", "receive",
                123456);

        test.add(1000.05);
        double returnValue = test.transfer(5.8, testReceive, 123456);

        BankAccount exp = new BankAccount1("give", "to", 123456);
        exp.add(994.25);
        double returnExp = 994.25;

        BankAccount expReceive = new BankAccount1("receive", "receive", 123456);
        expReceive.add(5.8);

        boolean returnCheck = Math.abs(returnValue - returnExp) <= 0.009;

        assertEquals(test, exp);
        assertEquals(testReceive, expReceive);

        assertEquals(returnCheck, true);

    }

    @Test
    public void transfer3() {
        BankAccount test = new BankAccount1("give", "to", 123456);
        BankAccount testReceive = new BankAccount1("receive", "receive",
                123456);

        test.add(5555555.55);
        double returnValue = test.transfer(999, testReceive, 123456);

        BankAccount exp = new BankAccount1("give", "to", 123456);
        exp.add(5554556.55);
        double returnExp = 5554556.55;

        BankAccount expReceive = new BankAccount1("receive", "receive", 123456);
        expReceive.add(999);

        boolean returnCheck = Math.abs(returnValue - returnExp) <= 0.009;

        assertEquals(test, exp);
        assertEquals(testReceive, expReceive);

        assertEquals(returnCheck, true);

    }

    /*
     * Tests of checkName
     */
    @Test
    public void checkName1() {
        BankAccount test = new BankAccount1("a", "b", 1111111);
        boolean actual = test.checkName("a", "b");
        boolean exp = true;

        assertEquals(actual, exp);

    }

    @Test
    public void checkName2() {
        BankAccount test = new BankAccount1("abc", "bfg", 1111111);
        boolean actual = test.checkName("abc", "bfg");
        boolean exp = true;

        assertEquals(actual, exp);

    }

    @Test
    public void checkName3() {
        BankAccount test = new BankAccount1("abc11", "bfg22", 1111111);
        boolean actual = test.checkName("abc11", "bfg22");
        boolean exp = true;

        assertEquals(actual, exp);

    }

    /*
     * Tests of equals
     */
    @Test
    public void equals1() {
        BankAccount test = new BankAccount1("a", "b", 1111111);
        BankAccount exp = new BankAccount1("a", "b", 1111111);
        boolean actual = test.equals(exp);
        boolean expcheck = true;

        assertEquals(actual, expcheck);

    }

    @Test
    public void equals2() {
        BankAccount test = new BankAccount1("abc", "b", 1111111);
        test.add(5);
        BankAccount exp = new BankAccount1("abc", "b", 1111111);
        exp.add(5);
        boolean actual = test.equals(exp);
        boolean expcheck = true;

        assertEquals(actual, expcheck);

    }

    @Test
    public void equals3() {
        BankAccount test = new BankAccount1("abc123", "b", 1111111);
        test.add(5);
        BankAccount exp = new BankAccount1("abc123", "b", 1111111);
        exp.add(5);
        boolean actual = test.equals(exp);
        boolean expcheck = true;

        assertEquals(actual, expcheck);

    }

    /*
     * Tests of toString
     */
    @Test
    public void toString1() {
        BankAccount test = new BankAccount1("a", "b", 1111111);
        BankAccount test2 = new BankAccount1("a", "b", 1111111);
        String actual = test.toString();
        String exp = test2.toString();

        assertEquals(actual, exp);

    }

    @Test
    public void toString2() {
        BankAccount test = new BankAccount1("a", "b", 1111111);
        test.add(100);
        BankAccount test2 = new BankAccount1("a", "b", 1111111);
        test2.add(100);
        String actual = test.toString();
        String exp = test2.toString();

        assertEquals(actual, exp);

    }

    @Test
    public void toString3() {
        BankAccount test = new BankAccount1("abc12", "bcd56", 1111111);
        test.add(99.9);
        BankAccount test2 = new BankAccount1("abc12", "bcd56", 1111111);
        test2.add(99.9);
        String actual = test.toString();
        String exp = test2.toString();

        assertEquals(actual, exp);

    }

}
