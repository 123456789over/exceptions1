package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Reservation;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int number = sc.nextInt();
		System.out.print("Check-in date (dd/MM/yyyy): ");
		LocalDate checkIn = LocalDate.parse(sc.next(), fm1);
		System.out.print("Check-out date (dd/MM/yyyy): ");
		LocalDate checkOut = LocalDate.parse(sc.next(), fm1);
		
		if (!checkOut.isAfter(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
		
		
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.print("Check-in date (dd/MM/yyyy): ");
			LocalDate checkIn2 = LocalDate.parse(sc.next(), fm1);
			System.out.print("Check-out date (dd/MM/yyyy): ");
			LocalDate checkOut2 = LocalDate.parse(sc.next(), fm1);
			
			LocalDate now = LocalDate.now();
		
			if (checkIn2.isBefore(now) || checkOut2.isBefore(now)) {
					System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(!checkOut.isAfter(checkIn) || !checkOut2.isAfter(checkOut) || !checkIn2.isAfter(checkIn)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDates(checkIn2, checkOut2);
				System.out.println("Updated reservation: " + reservation);
			}
		
		}
		
		
		sc.close();

	}

}
