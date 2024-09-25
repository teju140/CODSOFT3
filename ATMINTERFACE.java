
class BankAccount {
    private double balance;
    public BankAccount(double initialBalance) {
        if (initialBalance < 0) {
            System.out.println("Error: sorry! The balance cannot be negative.");
            this.balance = 0;
        } else {
            this.balance = initialBalance;
        }
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(" your Deposit Successful. New Balance: $" + balance);
        } else {
            System.out.println("Error: Deposit amount must be positive.");
        }
    }
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Error: Withdrawal amount must be greater than zero.");
        } else if (amount > balance) {
            System.out.println("Error: showing Insufficient balance.");
        } else {
            balance -= amount;
            System.out.println(" your Withdrawal Successful. New Balance: $" + balance);
        }
    }
    public double checkBalance() {
        return balance;
    }
}

class ATM {

    private BankAccount account;

    
    public ATM(BankAccount account) {
        this.account = account;
    }

   
    public void start() {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        int choice;

        do {
            System.out.println("\nATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    
                    System.out.println(" your Current Balance: $" + account.checkBalance());
                    break;

                case 2:
                    
                    System.out.print("Enter amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;

                case 3:
            
                    System.out.print("Enter amount to withdraw: $");
                    double withdrawAmount = scanner.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;

                case 4:
                    
                    System.out.println("Thank you for using our ATM.");
                    break;

                default:
                    System.out.println("Error: Invalid choice. Please select a valid option.");
            }
        } while (choice != 4);

        scanner.close();
    }

    public static void main(String[] args) {
        
        BankAccount userAccount = new BankAccount(1000);

        ATM atmMachine = new ATM(userAccount);

        atmMachine.start();
    }
}
