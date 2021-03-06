package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number");
		int number = sc.nextInt();
		System.out.println("Checkin date(dd/mm/yyyy): ");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Checkout date(dd/mm/yyyy): ");
		Date checkout = sdf.parse(sc.next());
		if (!checkout.after(checkin)) {
			System.out.println("Error in resevation: Chek-out date must be after check-in date.1");
		} else {
			Reservation reservation = new Reservation(number, checkin, checkout);
			
			System.out.println("Reservation: " + reservation);
			System.out.println();
			System.out.println("Enter data to update the reservation: ");
			System.out.println("Checkin date(dd/mm/yyyy): ");
			checkin = sdf.parse(sc.next());
			System.out.println("Checkout date(dd/mm/yyyy): ");
			checkout = sdf.parse(sc.next());
			reservation.updateDates(checkin, checkout);
		 
			System.out.println("Reservation: " + reservation);
			
		}
		sc.close();
	}

}
