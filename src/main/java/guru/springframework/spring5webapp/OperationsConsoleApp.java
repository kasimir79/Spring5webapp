package guru.springframework.spring5webapp;

import guru.springframework.spring5webapp.service.OperationsService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

//@Component
public class OperationsConsoleApp implements CommandLineRunner {

    private final OperationsService operationsService;
    private final Scanner scanner = new Scanner(System.in);

    public OperationsConsoleApp(OperationsService operationsService) {
        this.operationsService = operationsService;
    }

    @Override
    public void run(String... args) {
        while (true) {
            System.out.println("\n=== Calculator Menu ===");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Power");
            System.out.println("6. Modulus");
            System.out.println("7. Square Root");
            System.out.println("8. Factorial");
            System.out.println("9. Exit");
            System.out.print("Select an operation (1-9): ");

            int choice;
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number between 1 and 9.");
                scanner.next();
            }
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 9) {
                System.out.println("Exiting... Goodbye!");
                break;
            }

            int num1 = 0, num2 = 0;
            double result = 0.0;

            try {
                if (choice >= 1 && choice <= 6) {
                    System.out.print("Enter first number: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a valid integer.");
                        scanner.next();
                    }
                    num1 = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter second number: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a valid integer.");
                        scanner.next();
                    }
                    num2 = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 4 && num2 == 0) {
                        System.out.println("Error: Division by zero is not allowed.");
                        continue;
                    }
                } else if (choice == 7 || choice == 8) {
                    System.out.print("Enter a number: ");
                    while (!scanner.hasNextInt()) {
                        System.out.println("Invalid input! Please enter a valid integer.");
                        scanner.next();
                    }
                    num1 = scanner.nextInt();
                    scanner.nextLine();

                    if (choice == 7 && num1 < 0) {
                        System.out.println("Error: Cannot calculate square root of a negative number.");
                        continue;
                    }
                }

                switch (choice) {
                    case 1:
                        result = operationsService.add(num1, num2);
                        break;
                    case 2:
                        result = operationsService.subtract(num1, num2);
                        break;
                    case 3:
                        result = operationsService.multiply(num1, num2);
                        break;
                    case 4:
                        result = operationsService.divide((double) num1, (double) num2);
                        break;
                    case 5:
                        result = operationsService.power(num1, num2);
                        break;
                    case 6:
                        result = operationsService.modulus(num1, num2);
                        break;
                    case 7:
                        result = operationsService.sqrt((double) num1);
                        break;
                    case 8:
                        result = operationsService.factorial(num1);
                        break;
                    default:
                        System.out.println("Invalid choice, please try again.");
                        continue;
                }

                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {
                System.out.println("Math Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}
