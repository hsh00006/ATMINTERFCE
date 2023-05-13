import java.util.*;
public class Atminterface{
        // Define variables to store user's balance and transaction history
        private static double balance = 0;
        private static String transactionHistory = "Transaction history:\n";

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String username = "suman";
            String password = "851131";

            // Prompt user to enter username and password
            System.out.print("Enter your username: ");
            String inputUsername = sc.nextLine();
            System.out.print("Enter your password: ");
            String inputPassword = sc.nextLine();

            // Verify login credentials
            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                System.out.println("Login successful!\n");

                // Display main menu
                while (true) {
                    System.out.println("Main menu:");
                    System.out.println("1. Transaction history");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5. Quit");

                    // Prompt user to enter choice
                    System.out.print("Enter your choice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    switch (choice) {
                        case 1:
                            // Display transaction history
                            System.out.println(transactionHistory);
                            break;

                        case 2:
                            // Withdraw money
                            System.out.print("Enter amount to withdraw: ");
                            double amountToWithdraw = sc.nextDouble();
                            sc.nextLine();
                            if (amountToWithdraw > balance) {
                                System.out.println("Insufficient balance!");
                            } else {
                                balance -= amountToWithdraw;
                                transactionHistory += "Withdrawal of $" + amountToWithdraw + "\n";
                                System.out.println("Transaction successful!");
                            }
                            break;

                        case 3:
                            // Deposit money
                            System.out.print("Enter amount to deposit: ");
                            double amountToDeposit = sc.nextDouble();
                            sc.nextLine();
                            balance += amountToDeposit;
                            transactionHistory += "Deposit of $" + amountToDeposit + "\n";
                            System.out.println("Transaction successful!");
                            break;

                        case 4:
                            // Transfer money
                            System.out.print("Enter amount to transfer: ");
                            double amountToTransfer = sc.nextDouble();
                            sc.nextLine();
                            if (amountToTransfer > balance) {
                                System.out.println("Insufficient balance!");
                            } else {
                                System.out.print("Enter recipient's account number: ");
                                String recipientAccountNumber = sc.nextLine();
                                balance -= amountToTransfer;
                                transactionHistory += "Transfer of $" + amountToTransfer + " to account " + recipientAccountNumber + "\n";
                                System.out.println("Transaction successful!");
                            }
                            break;

                        case 5:
                            // Quit program
                            System.out.println("Exiting program...");
                            System.exit(0);
                            break;

                        default:
                            // Invalid choice
                            System.out.println("Invalid choice!");
                            break;
                    }

                    System.out.println("Current balance: $" + balance);
                }
            } else {
                System.out.println("Incorrect username or password. Exiting program...");
                System.exit(0);
            }
        }
    }