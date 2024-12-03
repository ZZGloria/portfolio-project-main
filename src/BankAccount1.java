/**
 * Bank Account component with primary methods. (Note: by package-wide
 * convention, all references are non-null.)
 *
 * @mathsubtypes <pre>
 * BANK_ACCOUNT is (
 *   money: double(non-negaative number),
 *   FirstName: string
 *   LastName: string
 *   password: int(non-negative)
 *   exemplar ba
 *   constraint ba.money >= 0
 *)
 *
 * </pre>
 * @mathmodel type BankAccountKernel is modeled by BANK_ACCOUNT
 *
 * @initially <pre>
 * ():
 *  ensures
 *   this = (0,"","",0)
 * (double money, String firstName, String lastName, int password):
 *  requires
 *   money >= 0
 *   firstName is not null
 *   lastName is not null
 *   password has 6 to 8 digit
 *  ensures
 *   this.money = money
 *   this.firstName =firstName
 *   this.lastName =lastName
 *   this.password = password
 * </pre>
 */
public class BankAccount1 extends BankAccountSecondary {

    /**
     * Representation of {@code this}.
     */
    private double money;

    private String firstName;

    private String lastName;

    private int password;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {

        // TODO - fill in body
        this.money = 0;
        this.firstName = null;
        this.lastName = null;
        this.password = 0;

    }

    /*
     * Constructors -----------------------------------------------------------
     */

    public BankAccount1(String FirstName, String LastName, int password) {
        assert FirstName != null : "Violation of: FirstName is not null";
        assert LastName != null : "Violation of: LastName is not null";
        assert 100000 <= password : "Violation of password need to be at least 6 digit";
        assert 10000000 >= password : "Violation of password need to be at most 8 digit";

        this.createNewRep();
        this.firstName = FirstName.toLowerCase();
        this.lastName = LastName.toLowerCase();
        this.password = password;

    }

    /**
     * subtract {@code this.money} by {@code k} .
     *
     * @param k
     *            the {@code double} to be subtract from money
     * @updates this
     * @requires {this.money >= k}
     * @ensures this = #this - k
     * @return this.money
     */
    @Override
    public double subtract(double k) {
        this.money -= k;
        return this.money;
    }

    /**
     * add {@code this.money} by {@code k} .
     *
     * @param k
     *            the {@code double} to be add to money
     * @updates this
     * @requires {@code k >= 0}
     * @ensures this = #this + k
     * @return this.money
     */
    @Override
    public double add(double k) {
        this.money += k;
        return this.money;
    }

    /**
     * check whether the input {@code pass} match {@code this.password}
     *
     * @param pass
     *            the {@code int} password to be check
     * @requires {100000 <= @code pass <= 99999999}
     * @ensures pass == this.password
     * @return true if pass matches password, false otherwise
     */
    @Override
    public boolean checkPassWord(int pass) {
        return this.password == pass;
    }

    /**
     * check whether the input {@code firstName} match {@code this.FirstName}
     *
     * @param firstName
     *            the {@code string} firstName to be check
     * @requires {@code firstName != null}
     * @ensures firstName.equals(this.FirstName)
     * @return true if firstName matches this.FirstName, false otherwise
     */
    @Override
    public boolean checkFirstName(String firstName) {
        return this.firstName.equals(firstName);
    }

    /**
     * check whether the input {@code LastName} match {@code this.LastName}
     *
     * @param LastName
     *            the {@code string} LastName to be check
     * @requires {@code LastName != null}
     * @ensures LastName.equals(this.LastName)
     * @return true if LastName matches this.LastName, false otherwise
     */
    @Override
    public boolean checkLastName(String LastName) {
        return this.lastName.equals(LastName);
    }

    /**
     * return the lastName
     *
     * @return this.lastName
     */
    @Override
    public String LastName() {
        return this.lastName;
    }

    /**
     * return the firstName
     *
     * @return this.firstName
     */
    @Override
    public String firstName() {
        return this.firstName;
    }

    @Override
    public final BankAccount newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(BankAccount source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof BankAccount : ""
                + "Violation of: source is of dynamic type NaturalNumberExample";

        BankAccount1 localSource = (BankAccount1) source;
        this.money = localSource.money;
        this.firstName = localSource.firstName;
        this.lastName = localSource.lastName;
        this.password = localSource.password;

        localSource.createNewRep();

    }

}
