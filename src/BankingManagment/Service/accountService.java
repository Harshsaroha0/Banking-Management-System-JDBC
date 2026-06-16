package BankingManagment.Service;

import BankingManagment.Dao.accountDao;
import BankingManagment.model.account;

public class accountService {
	
	accountDao dao = new accountDao();
	
	public void createAccount(String name , Double balance) {
		account acc = new account(name , balance);
		dao.createAccount(acc);
	}

	public Double checkBalance(int Id) {
		return dao.getBalance(Id);
	}
	
	public void deposit(int accountId, double amount) {
	    dao.deposit(accountId, amount);
	}
	
	public void withdraw(int accountId , double amount) {
		dao.withdraw(accountId , amount);
	}
	
	public void transferMoney(int fromAccId, int toAccId, double money) {

	    if (money <= 0) {
	        System.out.println("Transfer amount must be greater than 0");
	        return;
	    }

	    if (fromAccId == toAccId) {
	        System.out.println("Cannot transfer to the same account");
	        return;
	    }

	    dao.transferMoney(fromAccId, toAccId, money);
	}}
