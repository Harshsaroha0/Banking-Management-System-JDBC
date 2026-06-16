# Banking Management System

## Overview

A console-based Banking Management System developed using Java, JDBC, and MySQL. This project demonstrates core backend development concepts such as database connectivity, CRUD operations, transaction management, DAO Layer, and Service Layer architecture.

The application allows users to create bank accounts, check balances, deposit money, withdraw money, and transfer funds securely between accounts.

---

## Features

* Create New Bank Account
* Check Account Balance
* Deposit Money
* Withdraw Money
* Transfer Money Between Accounts
* Transaction Management using JDBC
* DAO Layer Architecture
* Service Layer Architecture
* MySQL Database Integration
* Exception Handling

---

## Technologies Used

* Java
* JDBC (Java Database Connectivity)
* MySQL
* Eclipse IDE
* MySQL Connector/J

---

## Project Structure

```text
BankingManagementSystem
│
├── DB
│   └── DbConnection.java
│
├── Dao
│   └── accountDao.java
│
├── Service
│   └── accountService.java
│
├── model
│   └── account.java
│
└── BankingApp.java
```

---

## Database Schema

### Table: account

```sql
CREATE TABLE account (
    accId INT PRIMARY KEY AUTO_INCREMENT,
    holdername VARCHAR(20),
    bal DOUBLE(10,2)
);
```

---

## Functionalities

### Create Account

Creates a new bank account with account holder name and initial balance.

### Check Balance

Retrieves the current balance of an account.

### Deposit Money

Adds money to an existing account.

### Withdraw Money

Withdraws money after validating sufficient balance.

### Transfer Money

Transfers money from one account to another using JDBC transaction management.

Transaction flow:

```text
Start Transaction
      ↓
Withdraw from Sender
      ↓
Deposit to Receiver
      ↓
Commit
```

If any operation fails:

```text
Rollback Transaction
```

---

## Learning Outcomes

This project helped in understanding:

* JDBC Connection Management
* PreparedStatement Usage
* CRUD Operations
* ResultSet Processing
* DAO Design Pattern
* Service Layer Design
* Transaction Management
* Exception Handling
* Real-world Banking Workflow

---

## How to Run

1. Clone the repository.
2. Open the project in Eclipse.
3. Add MySQL Connector/J JAR file.
4. Create the database and table using the SQL script.
5. Update database credentials in `DbConnection.java`.
6. Run `BankingApp.java`.

---

## Future Improvements

* Login Authentication
* Account Statement
* Interest Calculation
* Servlet and JSP Integration
* Spring Boot REST APIs
* Web-Based User Interface

---

## Author

Harsh Saroha

Java Backend Developer (Learning Path)

---

### GitHub Repository

If you found this project useful, feel free to star the repository.
