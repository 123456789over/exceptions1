package entities;

import exceptions.WithdrawException;
import model.exceptions.DomainException;

public class Account {

	private Integer number;
	private String holder;
	private Double balance;
	private Double withdrawLimit;
	
	public Account () {
		
	}

	public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
		if(number <= 0) {
			throw new DomainException ("Number of account can't be negative"); 
		}
		if(balance <= 0) {
			throw new DomainException ("Amount of balance can't be negative"); 
		}
		
		this.number = number;
		this.holder = holder;
		this.balance = balance;
		this.withdrawLimit = withdrawLimit;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public Double getWithdrawLimit() {
		return withdrawLimit;
	}

	public void setWithdrawLimit(Double withdrawLimit) {
		this.withdrawLimit = withdrawLimit;
	}

	public Integer getNumber() {
		return number;
	}

	public Double getBalance() {
		return balance;
	}
	
	public void deposit(double amount) {
		balance += amount;
	}
	public void withdraw(double amount) {
		if(amount > withdrawLimit) {
			throw new WithdrawException ("The amount exceeds withdraw limit"); 
		}
		else if(amount > balance) {
			throw new WithdrawException ("Not enough balance"); 
		} else {
			balance -= amount;
			System.out.println("New balance: " + balance);
		}		
	}
	
	
}
