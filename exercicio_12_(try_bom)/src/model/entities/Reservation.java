package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if (!checkOut.after(checkIn)) {
			throw new DomainException("Chek-out date must be after check-in date. [Constr]");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}

	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);

	}

	public void updateDates(Date checkin, Date checkout) {
		Date now = new Date();
		System.out.println(checkin);
		System.out.println(checkout);
		if (checkin.before(now) || checkout.before(now)) {
			throw new DomainException( "Error in reservation: Reservation date for updates must be future dates.2");
		}
		if (!checkout.after(checkin)) {
			throw new DomainException("Chek-out date must be after check-in date.3");
		}

		this.checkIn = checkin;
		this.checkOut = checkout;		
	}

	@Override
	public String toString() {
		return "ROOM " + roomNumber + ", checkin: " + sdf.format(checkIn) + ", checkout: " + sdf.format(checkOut) + ", "
				+ duration() + " nigths";
	}

}
