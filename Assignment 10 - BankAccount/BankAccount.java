import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class BankAccount {
    private String accountNumber;
    private double checkingBalance;
    private double savingsBalance;
    private static int numberOfAccounts = 0;
    private static ArrayList<HashMap<String, String>> totalAmount = new ArrayList<>();

    private String generateAccountNumber() {
        Random random = new Random();
        long randomNumber = Math.abs(random.nextLong()) % 10000000000L;
        return Long.toString(randomNumber);
    }
    
    public BankAccount() {
        this.accountNumber = generateAccountNumber();
        this.checkingBalance = 0.00;
        this.savingsBalance = 0.00;
        numberOfAccounts++;
        HashMap<String, String> item = new HashMap<>();
        item.put("Account Number", this.accountNumber);
        item.put("Total Amount", "0.00");
        totalAmount.add(item);
    }

    public double getCheckingBalance() {
        return this.checkingBalance;
    }

    public double getSavingsBalance() {
        return this.savingsBalance;
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    public void deposit(String accountType, double amount) {
        if (accountType == "savings") {
            this.savingsBalance += amount;
            System.out.printf("\nSuccessfully deposited %.2f PHP. Your savings balance is now %.2f PHP.\n", amount, this.getSavingsBalance());
        } else if (accountType == "checking") {
            this.checkingBalance += amount;
            System.out.printf("\nSuccessfully deposited %.2f PHP. Your checking balance is now %.2f PHP.\n", amount, this.getCheckingBalance());
        } else {
            System.out.println("\nDeposit transaction failed. Account doesn't exist. You need to specify the type of account correctly (savings or checking).");
        }
        for (HashMap<String, String> item : totalAmount) {
            if (item.containsKey("Account Number") && item.get("Account Number").equals(this.accountNumber)) {
                item.put("Total Amount", getTotalAmount());
            }
        }
    }

    public void withdraw(String accountType, double amount) {
        if (accountType == "savings") {
            if (amount > this.savingsBalance) {
                System.out.println("\nTransaction failed. Insufficient funds.");
            } else {
                this.savingsBalance -= amount;
                System.out.printf("\nSuccessfully withdrawn %.2f PHP from your account. Your savings balance is now %.2f PHP.\n", amount, this.savingsBalance);
            }
        } else if (accountType == "checking") {
            if (amount > this.checkingBalance) {
                System.out.println("\nTransaction failed. Insufficient funds.");
            } else {
                this.checkingBalance -= amount;
                System.out.printf("\nSuccessfully withdrawn %.2f PHP from your account. Your checking balance is now %.2f PHP.\n", amount, this.checkingBalance);
            }
        } else {
            System.out.println("You need to specify the type of account correctly (savings or checking).");
        }
        for (HashMap<String, String> item : totalAmount) {
            if (item.containsKey("Account Number") && item.get("Account Number").equals(this.accountNumber)) {
                item.put("Total Amount", getTotalAmount());
            }
        }
    }

    public String getTotalAmount() {
        return String.format("%.2f PHP", this.savingsBalance + this.checkingBalance);
    }

    public static int getNumberOfAccounts() {
        return numberOfAccounts;
    }
    
    public static ArrayList<HashMap<String, String>> getAllAccounts() {
        return totalAmount;
    }
}