package application2;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import exceptions.WithdrawException;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);	
		
		try {
			System.out.println("Enter account data: ");
			System.out.print("Number: ");
			int number = sc.nextInt();
			System.out.print("Holder: ");
			sc.nextLine();
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double initial = sc.nextDouble();
			System.out.print("Withdraw limit: ");
			double limit = sc.nextDouble();
			
			Account account = new Account(number, holder, initial, limit);
			
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);
			
		}
		catch (DomainException e) {
			System.out.println("Error on enter account data: " + e.getMessage());
		}
		catch (WithdrawException e) {
			System.out.println("Withdraw error: " + e.getMessage());
		}	
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		finally {
			sc.close();
		}

	}

}
