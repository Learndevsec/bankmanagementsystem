// Bank.java
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void addAccount(Account account) {
        accounts.add(account);
        System.out.println("Account added successfully: " + account.accountNumber);
    }

    public Account findAccount(String accountNumber) {
        for (Account acc : accounts) {
            if (acc.accountNumber.equals(accountNumber)) {
                return acc;
            }
        }
        return null;
    }

    public void showAllAccounts() {
        for (Account acc : accounts) {
            acc.displayDetails();
            System.out.println("----------------------------");
        }
    }
}
