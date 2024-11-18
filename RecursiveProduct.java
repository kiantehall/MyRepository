import java.util.Scanner;

public class RecursiveProduct {

    // Recursive method to calculate the product
    public static int calculateProduct(int[] numbers, int index) {
        // Base case: when index reaches the length of the array
        if (index == numbers.length) {
            return 1; // End of recursion, return 1
        }
        
        // Recursive case: multiply the current number by the result of the next call
        return numbers[index] * calculateProduct(numbers, index + 1);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Array to hold five numbers
        int[] numbers = new int[5];

        // Get user input
        System.out.println("Please enter 5 numbers:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        // Calculate the product using recursion
        int product = calculateProduct(numbers, 0);

        // Output the result
        System.out.println("The product of the numbers is: " + product);
        
        scanner.close();
    }
}