public class TestBankAccounts {
    public static void main(String[] args) {
        // Create a regular bank account
        BankAccount regularAccount = new BankAccount("John", "Doe", 12345);
        regularAccount.deposit(1000);
        regularAccount.accountSummary();
        System.out.println();

        // Create a checking account
        CheckingAccount checkingAccount = new CheckingAccount("Jane", "Smith", 54321, 1.5);
        checkingAccount.deposit(500);
        checkingAccount.displayAccount();
        System.out.println();

        // Test withdrawal without overdraft
        checkingAccount.processWithdrawal(300);
        checkingAccount.displayAccount();
        System.out.println();

        // Test withdrawal with overdraft
        checkingAccount.processWithdrawal(250); // This will trigger an overdraft
        checkingAccount.displayAccount();
    }
}