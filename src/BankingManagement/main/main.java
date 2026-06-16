package BankingManagement.main;

import java.util.Scanner;

import BankingManagment.Service.accountService;

public class main {
    public static void main(String[] args) {

        accountService service = new accountService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transaction");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.next();
                    System.out.print("Enter initial balance: ");
                    double bal = sc.nextDouble();
                    service.createAccount(name, bal);
                    break;

                case 2:
                    System.out.print("Enter account id: ");
                    int id = sc.nextInt();
                    System.out.println("Balance: " + service.checkBalance(id));
                    break;

                case 3:
                    System.out.print("Enter Account ID: ");
                    int accountId = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double amount = sc.nextDouble();

                    service.deposit(accountId, amount);

                    break;
                 
                case 4:
                    System.out.println("Enter Account ID : ");
                    int withdrawAccountId = sc.nextInt();
                    
                    System.out.println("Enter Amount :");
                    double withdrawAmount = sc.nextDouble();
                    break;
                    
                case 5:
                	System.out.println("enter FromAccId :");
                	int fromAccId = sc.nextInt();
                	
                	System.out.println("Enter toAccId : ");
                	int toAccId = sc.nextInt();
                	
                	System.out.println("Enter amount :");
                	double money = sc.nextDouble();
                    
                case 6:
                	System.out.println("Thank you for using Banking System");
                    System.exit(0);

                    break; 	
            }
        }
    }
}