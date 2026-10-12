import java.util.Scanner;

public class BankAccount {

    static Scanner sc = new Scanner(System.in);

    static long accountNumber;
    static String customerName;
    static double balance;

    // Accept and store customer details
    static void entry() {
        System.out.print("Enter Account Number: ");
        accountNumber = sc.nextLong();
        sc.nextLine();

        System.out.print("Enter Customer Name: ");
        customerName = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        balance = sc.nextDouble();

        while (balance < 0) {
            System.out.print("Balance cannot be negative. Enter Initial Balance: ");
            balance = sc.nextDouble();
        }

        System.out.println("\nAccount created successfully for " + customerName + "!");
    }

    // Deposit money
    static void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = sc.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful! Amount deposited: " + amount);
        } else {
            System.out.println("Invalid amount! Deposit amount must be greater than 0.");
        }
    }

    // Withdraw money
    static void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = sc.nextDouble();

        if (amount <= 0) {
            System.out.println("Invalid amount! Withdrawal amount must be greater than 0.");
        } else if (amount > balance) {
            System.out.println("Insufficient Balance");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful! Amount withdrawn: " + amount);
        }
    }

    // Display current balance
    static void returnBalance() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Customer Name  : " + customerName);
        System.out.println("Current Balance: " + balance);
    }

    // Thank-you message and terminate
    static void exit() {
        System.out.println("\nThank you for banking with us, " + customerName + "!");
        sc.close();
        System.exit(0);
    }

    public static void main(String[] args) {

        System.out.println("===== BANK ACCOUNT MANAGEMENT SYSTEM =====");
        entry();

        while (true) {
            System.out.println("\n------------- MENU -------------");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    returnBalance();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1-4.");
            }
        }
    }
}