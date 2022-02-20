package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer room_num;
	private Date checkin;
	private Date checkout;
	Date now = new Date();
	private static SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	
	public Reservation() {
	}
	
	public Reservation(Integer room_num, Date checkin, Date checkout) {
		if(!checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates!");
		}
		this.room_num = room_num;
		this.checkin = checkin;
		this.checkout = checkout;
	}

	public Integer getRoom_num() {
		return room_num;
	}

	public void setRoom_num(Integer room_num) {
		this.room_num = room_num;
	}

	public Date getCheckin() {
		return checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public long duration() {
		long diff = checkout.getTime()-checkin.getTime();
		return TimeUnit.DAYS.convert(diff,TimeUnit.MILLISECONDS);
	}
	
	
	
	public void updateDates(Date checkout,Date checkin){
		if(!checkin.before(now) || checkout.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates!");
		}
		if(!checkout.after(checkin)) {
			throw new DomainException("Checkout date must be after check-in date!");
		}
		
		this.checkin = checkin;
		this.checkout = checkout;
	}
	
	
	
	
	
	@Override
	public String toString() { 
		return "Room:"
				+room_num 
				+", checkin:"
				+sdf.format(checkin)
				+", checkout"
				+sdf.format(checkout)
				+", "
				+duration()
				+" nights";
	}
	
	
	
	
	
	
	
	
}
