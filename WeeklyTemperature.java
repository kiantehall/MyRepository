import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperature {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize ArrayLists
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // Store days and temperatures
        for (String day : weekDays) {
            days.add(day);
            System.out.print("Enter the average temperature for " + day + ": ");
            double temp = scanner.nextDouble();
            temperatures.add(temp);
        }

        // User interaction
        while (true) {
            System.out.print("Enter a day of the week or 'week' to see all temperatures: ");
            String input = scanner.next();
            
            if (input.equalsIgnoreCase("week")) {
                // Display temperatures for each day and the weekly average
                double totalTemp = 0;
                for (int i = 0; i < days.size(); i++) {
                    System.out.println(days.get(i) + ": " + temperatures.get(i) + "°C");
                    totalTemp += temperatures.get(i);
                }
                double averageTemp = totalTemp / days.size();
                System.out.println("Weekly average temperature: " + averageTemp + "°C");
            } else {
                // Display temperature for the specified day
                boolean found = false;
                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).equalsIgnoreCase(input)) {
                        System.out.println(input + ": " + temperatures.get(i) + "°C");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Invalid day entered. Please try again.");
                }
            }

            System.out.print("Would you like to check another day or 'week'? (yes/no): ");
            String continueInput = scanner.next();
            if (continueInput.equalsIgnoreCase("no")) {
                break;
            }
        }

        scanner.close();
    }
}