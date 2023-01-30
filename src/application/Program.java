package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Reservation;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		try {
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), fm1);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), fm1);

		Reservation reservation = new Reservation(number, checkIn, checkOut);
		System.out.println("Reservation: " + reservation);

		System.out.println();
		System.out.println("Enter data to update the reservation: ");
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn2 = LocalDate.parse(sc.next(), fm1);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut2 = LocalDate.parse(sc.next(), fm1);

		reservation.updateDates(checkIn2, checkOut2);
		System.out.println("Updated reservation: " + reservation);
		

		}
		catch (DateTimeParseException e) {
			System.out.println("Invalid Format Date");
		}
		catch (DomainException e){
			System.out.println("Error in reservation: " + e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Unexpected error");
		}
		
		sc.close();
		
	}

}
