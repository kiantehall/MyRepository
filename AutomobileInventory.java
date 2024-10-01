import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AutomobileInventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Automobile car = new Automobile("Toyota", "Camry", "Blue", 2020, 15000);

        try {
            // List vehicle information
            System.out.println("Vehicle Information:");
            displayVehicleInfo(car);

            // Remove vehicle
            String removeMessage = car.removeVehicle();
            System.out.println(removeMessage);

            // Add a new vehicle
            String addMessage = car.addNewVehicle("Honda", "Civic", "Red", 2022, 5000);
            System.out.println(addMessage);

            // List new vehicle information
            System.out.println("New Vehicle Information:");
            displayVehicleInfo(car);

            // Update vehicle attributes interactively
            updateVehicleInteractively(car, scanner);

            // List updated vehicle information
            System.out.println("Updated Vehicle Information:");
            displayVehicleInfo(car);

            // Ask if the user wants to print the information to a file
            System.out.print("Do you want to print the information to a file? (Y/N): ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("Y")) {
                printToFile(car.listVehicleInformation());
                System.out.println("Vehicle information printed to file.");
            } else {
                System.out.println("File will not be printed.");
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Method to display vehicle information
    public static void displayVehicleInfo(Automobile car) {
        String[] vehicleInfo = car.listVehicleInformation();
        for (String info : vehicleInfo) {
            System.out.println(info);
        }
    }

    // Method to interactively update vehicle attributes
    public static void updateVehicleInteractively(Automobile car, Scanner scanner) {
        try {
            System.out.print("Enter new make: ");
            String make = scanner.nextLine();
            System.out.print("Enter new model: ");
            String model = scanner.nextLine();
            System.out.print("Enter new color: ");
            String color = scanner.nextLine();
            System.out.print("Enter new year: ");
            int year = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter new mileage: ");
            int mileage = Integer.parseInt(scanner.nextLine());

            String updateMessage = car.updateVehicleAttributes(make, model, color, year, mileage);
            System.out.println(updateMessage);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for year or mileage: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred while updating vehicle: " + e.getMessage());
        }
    }

    // Method to print vehicle information to a file
    public static void printToFile(String[] vehicleInfo) {
        String filePath = "C:\\Temp\\Autos.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String info : vehicleInfo) {
                writer.write(info);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to print to file: " + e.getMessage());
        }
    }
}