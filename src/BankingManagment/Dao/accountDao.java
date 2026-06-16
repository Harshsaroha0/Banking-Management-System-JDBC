package BankingManagment.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import BankingManagment.DB.DbConnection;
import BankingManagment.model.account;

public class accountDao {

    // Create Account
    public void createAccount(account acc) {

        try {
            Connection con = DbConnection.getConnection();

            String sql =
                    "INSERT INTO account(holdername, bal) VALUES (?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, acc.getName());
            ps.setDouble(2, acc.getBalance());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Account Created Successfully");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Get Balance
    public double getBalance(int accountId) {

        double balance = 0.0;

        try {
            Connection con = DbConnection.getConnection();

            String sql =
                    "SELECT bal FROM account WHERE accId = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                balance = rs.getDouble("bal");
            } else {
                System.out.println("Account Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return balance;
    }

    // Deposit Money
    public void deposit(int accountId, double amount) {

        try {
            Connection con = DbConnection.getConnection();

            String sql =
                    "UPDATE account SET bal = bal + ? WHERE accId = ?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setDouble(1, amount);
            ps.setInt(2, accountId);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Deposit Successful");
            } else {
                System.out.println("Account Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Withdraw Money
    public void withdraw(int accountId, double amount) {

        try {
            Connection con = DbConnection.getConnection();

            String checkSql =
                    "SELECT bal FROM account WHERE accId = ?";

            PreparedStatement ps = con.prepareStatement(checkSql);

            ps.setInt(1, accountId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                double balance = rs.getDouble("bal");

                if (balance < amount) {
                    System.out.println("Insufficient Balance");
                    return;
                }

                String updateSql =
                        "UPDATE account SET bal = bal - ? WHERE accId = ?";

                PreparedStatement ps1 =
                        con.prepareStatement(updateSql);

                ps1.setDouble(1, amount);
                ps1.setInt(2, accountId);

                int rows = ps1.executeUpdate();

                if (rows > 0) {
                    System.out.println("Withdrawal Successful");
                } else {
                    System.out.println("Withdrawal Failed");
                }

            } else {
                System.out.println("Account Not Found");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //transaction method 
    public void transferMoney(int fromAccId , int toAccId , double money) {
    	 
    	Connection con = null;
  
    	try {
    		con = DbConnection.getConnection();
    		String checksql = "SELECT bal FROM account WHERE accId = ?";
    		PreparedStatement checkps = con.prepareStatement(checksql);
    		checkps.setInt(1, fromAccId);
    		
    		ResultSet rs = checkps.executeQuery();
    		
    		if(!rs.next()) {
    			System.out.println("sender account not found");
    		}
    		
            double balance = rs.getDouble("bal");
            
            if (balance < money) {
                System.out.println("Insufficient Balance");
                return;
            }
            
            String withdrawsql = "UPDATE account SET bal = bal - ? WHERE accId = ?";
            
            PreparedStatement withdrawPs =
                    con.prepareStatement(withdrawsql);

            withdrawPs.setDouble(1, money);
            withdrawPs.setInt(2, fromAccId);

            withdrawPs.executeUpdate();
            
            String depositSql ="UPDATE account SET bal = bal + ? WHERE accId = ?";

            PreparedStatement depositPs =con.prepareStatement(depositSql);

            depositPs.setDouble(1, money);
            depositPs.setInt(2, toAccId);

            int rows = depositPs.executeUpdate();

            if (rows == 0) {
                throw new Exception("Receiver Account Not Found");
            }

            con.commit();

            System.out.println("Money Transferred Successfully");

    	} catch (Exception e ) {
    		
    		try {
                if (con != null) {
                    con.rollback();
                    System.out.println("Transaction Rolled Back");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
    		
    		e.printStackTrace();
    	} finally {

            try {
                if (con != null) {
                    con.setAutoCommit(true);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}