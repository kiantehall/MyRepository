public class CheckingAccount extends BankAccount {
    private double interestRate;
    private static final double OVERDRAFT_FEE = 30.0;

    // Constructor
    public CheckingAccount(String firstName, String lastName, int accountID, double interestRate) {
        super(firstName, lastName, accountID);
        this.interestRate = interestRate;
    }

    // Overridden withdrawal method to handle overdrafts
    public void processWithdrawal(double amount) {
        if (amount > 0) {
            if (amount <= getBalance()) {
                withdrawal(amount);
            } else {
                System.out.println("Overdraft! A $30 fee will be applied.");
                withdrawal(getBalance());
                withdrawal(OVERDRAFT_FEE);
            }
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to display account details along with interest rate
    public void displayAccount() {
        accountSummary();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}