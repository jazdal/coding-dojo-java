public class TestBankAccount {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount();
        BankAccount account2 = new BankAccount();
        BankAccount account3 = new BankAccount();

        System.out.println(account1.getAccountNumber());
        account1.deposit("savings", 150.55);
        account1.deposit("checking", 360.75);
        account1.deposit("savings", 345.65);
        account1.deposit("timeDeposit", 500.00);
        account1.withdraw("savings", 1000.00);
        account1.withdraw("savings", 45.00);
        account1.withdraw("checking", 3000.00);
        account1.withdraw("checking", 300.00);
        System.out.println(account1.getCheckingBalance());
        System.out.println(account1.getSavingsBalance());
        System.out.println(account1.getTotalAmount());

        System.out.println(account2.getAccountNumber());
        account2.deposit("savings", 350.65);
        account2.deposit("checking", 865.99);
        account2.withdraw("savings", 200.00);

        System.out.println(account3.getAccountNumber());
        account3.deposit("savings", 1534.65);
        account3.deposit("checking", 3245.33);
        account3.withdraw("checking", 2000.00);
        account1.deposit("savings", 5440.99);

        System.out.println(BankAccount.getNumberOfAccounts());
        System.out.println(BankAccount.getAllAccounts());
    }
}