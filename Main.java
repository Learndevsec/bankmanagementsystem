// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner sc = new Scanner(System.in);

        // Adding sample accounts
        bank.addAccount(new SavingsAccount("SA101", "Alice", 5000, 5));
        bank.addAccount(new CurrentAccount("CA201", "Bob", 2000, 1000));

        while (true) {
            System.out.println("\n--- Bank Menu ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Show Accounts");
            System.out.println("4. Add Interest (Savings Only)");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter Account Number: ");
                    String accNo1 = sc.next();
                    Account acc1 = bank.findAccount(accNo1);
                    if (acc1 != null) {
                        System.out.print("Enter deposit amount: ");
                        double amount = sc.nextDouble();
                        acc1.deposit(amount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    String accNo2 = sc.next();
                    Account acc2 = bank.findAccount(accNo2);
                    if (acc2 != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double amt = sc.nextDouble();
                        try {
                            acc2.withdraw(amt);
                        } catch (InsufficientBalanceException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 3:
                    bank.showAllAccounts();
                    break;

                case 4:
                    for (Account acc : bank.accounts) {
                        if (acc instanceof SavingsAccount) {
                            ((SavingsAccount) acc).addInterest();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}
