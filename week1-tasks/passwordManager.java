import java.util.*;
import java.io.*;

public class passwordManager {

    private static final String FILE_PATH = "passwords.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Simple Password Manager");

        while (true) {
            System.out.println("\n1. Store new password");
            System.out.println("2. Retrieve password");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                storePassword(scanner);
            } else if (choice == 2) {
                retrievePassword(scanner);
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Please try again.");
            }
        }

    }

    private static void storePassword(Scanner scanner) {
        System.out.print("Enter service name: ");
        String service = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (PrintWriter out = new PrintWriter(new FileWriter(FILE_PATH, true))) {
            out.println(service + ":" + username + ":" + password);
            System.out.println("Password stored successfully!");
        } catch (IOException e) {
            System.out.println("Error storing the password." + e.getMessage());
        }
    }

    private static void retrievePassword(Scanner scanner) {
        System.out.print("Enter service name: ");
        String service = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            boolean found = false;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":");
                if (parts[0].equals(service)) {
                    System.out.println("Username: " + parts[1]);
                    System.out.println("Password: " + parts[2]);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("No password found for the given service.");
            }

        } catch (IOException e) {
            System.out.println("Error retrieving the password." + e.getMessage());
        }
    }
}
