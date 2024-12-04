public interface BankAccount extends BankAccountKernel {

    /**
     * extract {@code this.money} by {@code k} .
     *
     * @param k
     *            the {@code double} to be extract from money
     * @param password
     *            the {@code password} of the account you want to take money
     *            from
     * @updates this
     * @return the money in your account
     * @requires {this.money >= k}
     * @ensures this = #this - k if password is correct
     */
    double extract(double k, int password);

    /**
     * deposit {@code this.money} by {@code k} .
     *
     * @param k
     *            the {@code double} to be add to money
     * @updates this
     * @requires {@code k >= 0}
     * @return the money in your account
     * @ensures this = #this + k
     */
    double deposit(double k);

    /**
     * extract {@code this.money} by {@code k} .
     *
     * @param k
     *            the {@code double} to be extract from money
     * @param account
     *            the {@code BankAccount} that you transfer money to
     * @param password
     *            the {@code password} of the account you want to take money
     *            from
     * @updates this, account.this
     * @return The remaining money in your account
     * @requires {this.money >= k}
     * @ensures this = #this - k if password is correct account.this =
     *          #account.this + k
     */
    double transfer(double k, BankAccount account, int password);

    /**
     * check whether the input {@code firstName} match {@code this.FirstName}
     * and {@code lastName} match {@code this.LastName}.
     *
     * @param first
     *            the {@code string} firstName to be check
     * @param last
     *            the {@code string} lastName to be check
     * @requires {@code first != null} {@code last != null}
     * @ensures firstName.equals(this.FirstName) last.equals(this.LastName)
     * @return true if first matches this.FirstName and last matches
     *         this.LastName, false otherwise
     */
    boolean checkName(String first, String last);

}
