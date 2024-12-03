/**
 * Bank Account kernel component with primary methods. (Note: by package-wide
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
public interface BankAccountKernel extends Standard<BankAccount> {

    /**
     * A constant, with value 10, holding the radix (or base) for BankAccount.
     */
    int RADIX = 10;

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
    double subtract(double k);

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
    double add(double k);

    /**
     * check whether the input {@code pass} match {@code this.password}
     *
     * @param pass
     *            the {@code int} password to be check
     * @requires {100000 <= @code pass <= 99999999}
     * @ensures pass == this.password
     * @return true if pass matches password, false otherwise
     */
    boolean checkPassWord(int pass);

    /**
     * check whether the input {@code firstName} match {@code this.FirstName}
     *
     * @param firstName
     *            the {@code string} firstName to be check
     * @requires {@code firstName != null}
     * @ensures firstName.equals(this.FirstName)
     * @return true if firstName matches this.FirstName, false otherwise
     */
    boolean checkFirstName(String firstName);

    /**
     * check whether the input {@code LastName} match {@code this.LastName}
     *
     * @param LastName
     *            the {@code string} LastName to be check
     * @requires {@code LastName != null}
     * @ensures LastName.equals(this.LastName)
     * @return true if LastName matches this.LastName, false otherwise
     */
    boolean checkLastName(String LastName);

    /**
     * return the lastName
     *
     * @return this.lastName
     */
    String LastName();

    /**
     * return the firstName
     *
     * @return this.firstName
     */
    String firstName();

}