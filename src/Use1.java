
/**
 * demonstration of this BankAccount Class. This BankAccount class have a
 * similar function as a actual bank Account you could send, receive, deposit,
 * and extract money.
 */
public class Use1 {

    /**
     * @param args
     *            I will demonstrate the basic function of how to use this
     *            bankAccount.
     */
    public static void main(String[] args) {

        /*
         * Creating a bankAccount using your first and last name with a password
         */
        BankAccount myAccount = new BankAccount1("Gloria", "Zhong", 123456);

        //You could deposit money inside your account and see how much money are left
        System.out.println(myAccount.deposit(1000));

        //Here you extract money from account, exraction of money require password
        System.out.println(myAccount.extract(50, 123456));

        BankAccount otherAccount = new BankAccount1("Glena", "Zhong", 111111);

        //You could transfer money to another account
        myAccount.transfer(50,  otherAccount , 123456);

    }
}