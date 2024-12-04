
public abstract class BankAccountSecondary implements BankAccount {
    /**
     * extract {@code this.money} by {@code k} .
     *
     * @param k
     *            the {@code double} to be extract from money
     * @param password
     *            the {@code password} of the account you want to take money
     *            from
     * @updates this
     * @requires {this.money >= k}
     * @ensures this = #this - k if password is correct
     * @return the amount left in your account
     */
    @Override
    public double extract(double k, int password) {
        double ret = this.subtract(0);
        if (this.checkPassWord(password)) {
            ret = this.subtract(k);
        }

        return ret;
    }

    /**
     * deposit {@code this.money} by {@code k} .
     *
     * @param k
     *            the {@code double} to be add to money
     * @updates this
     * @requires {@code k >= 0}
     * @ensures this = #this + k
     * @return the amount left in your account
     */
    @Override
    public double deposit(double k) {
        double ret = this.add(k);

        return ret;
    }

    /**
     * extract {@code this.money} by {@code k} .
     *
     * @param k
     *            the {@code double} to be extract from money
     * @param receiver
     *            the {@code BankAccount} that you transfer money to
     * @param password
     *            the {@code password} of the account you want to take money
     *            from
     * @updates this, account.this
     * @requires {this.money >= k}
     * @ensures this = #this - k if password is correct account.this =
     *          #account.this + k
     * @return the amount left in this.money
     */
    @Override
    public double transfer(double k, BankAccount receiver, int password) {

        double ret = this.add(0);

        if (this.checkPassWord(password)) {
            ret = this.extract(k, password);
            receiver.add(k);
        }

        return ret;
    }

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
    @Override
    public boolean checkName(String first, String last) {
        return this.checkFirstName(first) && this.checkLastName(last);
    }

    @Override
    public boolean equals(Object o) {
        BankAccount account = (BankAccount) o;
        boolean balance = Math
                .abs(this.subtract(0) - account.subtract(0)) <= 0.009;
        return this.checkName(account.firstName(), account.lastName())
                && balance;

    }

    @Override
    public String toString() {
        String information = "";
        information = "name:" + this.firstName() + " " + this.lastName();
        information += "balance:" + this.subtract(0);
        return information;

    }

}
