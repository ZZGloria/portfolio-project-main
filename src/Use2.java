
/**
 * demonstration of this BankAccount Class. This BankAccount class have a
 * similar function as a actual bank Account you could send, receive, deposit,
 * and extract money.
 */
public class Use2 {

    /**
     * @param args
     *            I will demonstrate some usage of the bank account
     */
    public static void main(String[] args) {

        /*
         * Creating a bankAccount using your first and last name with a password
         */
        BankAccount myAccount = new BankAccount1("Gloria", "Zhong", 123456);
        BankAccount otherAccount = new BankAccount1("Glena", "Zhong", 111111);

        //here are some daily useage of a bank accountmight have

        //this would be like your salary
        myAccount.deposit(5000);

        //this kind of extraction simulate your daily usage like shopping
        myAccount.extract(67, 123456);
        myAccount.extract(25, 123456);
        myAccount.extract(80, 123456);

        //you could also transfer money to other people like friend or family
        myAccount.transfer(35, otherAccount, 123456);

        //your friend or family could also transfer money to you
        otherAccount.transfer(60, otherAccount, 111111);

    }
}