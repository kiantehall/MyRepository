import java.util.Scanner;

public class TaxCalculator {

    public static double calculateTax(double income) {
        double taxRate;
        if (income < 500) {
            taxRate = 0.10;
        } else if (income >= 500 && income < 1500) {
            taxRate = 0.15;
        } else if (income >= 1500 && income < 2500) {
            taxRate = 0.20;
        } else {
            taxRate = 0.30;
        }
        return income * taxRate;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter weekly income: ");
        double weeklyIncome = scanner.nextDouble();

        double weeklyTax = calculateTax(weeklyIncome);

        System.out.println("Weekly tax withholding: $" + String.format("%.2f", weeklyTax));
        
        scanner.close();
    }
}