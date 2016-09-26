package Laboratory5;

public class Account {
	private int accountNumber;
	private double balance = 0.0;
	
	public Account(int accountNumber, double balance) {
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	
	public Account(int accountNumber) {
		this(accountNumber, 0.0);
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void credit(double amount) {
		balance = balance + amount;
	}
	
	public void debit(double amount) {
		if(balance >= amount) {
			balance = balance - amount;
		}
		else {
			System.out.println("Amount withdrawn exceeds the current balance!");
		}
	}
	
	public String toString() {
        return String.format("A/C no:%d, Balance=$%.02f", accountNumber, balance);
    }
	
}
