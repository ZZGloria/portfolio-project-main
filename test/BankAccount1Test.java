
/**
 * Customized JUnit test fixture for {@code NaturalNumber3}.
 */
public class BankAccount1Test extends BankAccountTest {
    @Override
    protected final BankAccount constructorTest(String first, String last,
            int pass) {
        return new BankAccount1(first, last, pass);
    }

    @Override
    protected final BankAccount constructorRef(String first, String last,
            int pass) {
        return new BankAccount1(first, last, pass);
    }

}
