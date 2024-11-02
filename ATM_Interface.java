import java.util.Scanner;
import java.util.InputMismatchException;

class ATM_Machine {
    protected float balance;

    public ATM_Machine(float initialBalance) {
        this.balance = initialBalance;
    }
    public void withdraw(float amount) {
        if ((balance - amount) >= 500) {
            balance -= amount;
            System.out.println("\nWithdrawal successful. Your current balance is " + balance);
        }
        else {
            System.out.println("Insufficent balance. Minimum balance of 500 is required.");
        }
    }
    public void deposit(float amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount. Please enter a positive value.");
            return;
        }
        balance += amount;
        System.out.println("Deposit successful. Your current balance is " + balance);
    }
    public void checkBalance() {
        System.out.println("Your account balance is " + balance);
    }
}
class Bank_Account extends ATM_Machine {
    public Bank_Account(float initialBalance) {
        super (initialBalance);
    }
}
public class ATM_Interface {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Bank_Account account = new Bank_Account(500);

        int userChoice = 0;

        while (userChoice != 4) {
            System.out.println("\nChoose you option (Enter 1-4):");
            System.out.println("\t1. Check Balance\n\t2. Withdraw\n\t3. Deposit\n\t4. Exit");

            try {
                userChoice = sc.nextInt();

                switch(userChoice) {
                    case 1:
                        account.checkBalance();
                        break;
                    case 2:
                        System.out.print("\nEnter the amount to withdraw: ");
                        float withdrawAmount = sc.nextFloat();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("\nEnter the amount to deposit: ");
                        float depositAmount = sc.nextFloat();
                        account.deposit(depositAmount);
                        break;
                    case 4:
                        System.out.println("\nThank you for banking with us!\n");
                        break;
                    default:
                        System.out.println("\nInvalid input! Please enter a number between 1-4.");
                }
            }
            catch(InputMismatchException e) {
                System.out.println("\nInvalid input! Please enter numbers only.");
                sc.next();
            }
        }
        sc.close();
    }
}