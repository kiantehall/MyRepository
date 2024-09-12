import java.util.Scanner;

public class DataAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize variables
        double total = 0.0;
        double max = Double.NEGATIVE_INFINITY;
        double min = Double.POSITIVE_INFINITY;
        int count = 0;
        final int NUM_VALUES = 5;

        // Read 5 floating-point values
        while (count < NUM_VALUES) {
            System.out.print("Enter a floating-point value: ");
            if (scanner.hasNextDouble()) {
                double value = scanner.nextDouble();
                total += value;
                if (value > max) {
                    max = value;
                }
                if (value < min) {
                    min = value;
                }
                count++;
            } else {
                System.out.println("Invalid input. Please enter a valid floating-point number.");
                scanner.next(); // Clear invalid input
            }
        }

        // Calculate average and interest
        double average = total / NUM_VALUES;
        double interest = total * 0.20;

        // Print results
        System.out.printf("Total: %.2f%n", total);
        System.out.printf("Average: %.2f%n", average);
        System.out.printf("Maximum: %.2f%n", max);
        System.out.printf("Minimum: %.2f%n", min);
        System.out.printf("Interest on total at 20%%: %.2f%n", interest);

        scanner.close();
    }
}