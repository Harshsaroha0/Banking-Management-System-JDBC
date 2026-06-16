package BankingManagment.model;

public class account {
	
	private int accountId;
    private String name;
    private double balance;
    
    public account(String name , Double balance) {
    	this.name = name;
    	this.balance = balance;
    }
    
    public int getAccount() {
    	return accountId;
    }
    
    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    
    public String getName() {
    	return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Double getBalance() {
    	return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }

}
