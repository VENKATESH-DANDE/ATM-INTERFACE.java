import java.util.Scanner;

// Class to represent the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        } else {
            return false; // Insufficient balance
        }
    }
}

// Class to represent the ATM machine
public class ATM {
    private BankAccount bankAccount;

    public ATM(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    // Method to perform the selected operation
    public void performOperation(int choice) {
        Scanner scanner = new Scanner(System.in);

        switch (choice) {
            case 1:
                System.out.println("Balance: $" + bankAccount.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: $");
                double depositAmount = scanner.nextDouble();
                bankAccount.deposit(depositAmount);
                System.out.println("Deposit successful. New balance: $" + bankAccount.getBalance());
                break;
            case 3:
                System.out.print("Enter withdrawal amount: $");
                double withdrawalAmount = scanner.nextDouble();
                if (bankAccount.withdraw(withdrawalAmount)) {
                    System.out.println("Withdrawal successful. New balance: $" + bankAccount.getBalance());
                } else {
                    System.out.println("Insufficient balance. Withdrawal failed.");
                }
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid choice. Please select a valid option.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter initial balance: $");
        double initialBalance = scanner.nextDouble();

        BankAccount bankAccount = new BankAccount(initialBalance);
        ATM atm = new ATM(bankAccount);

        while (true) {
            atm.displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.performOperation(choice);
        }
    }
}
