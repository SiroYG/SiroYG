package model;

import java.util.Date;

public class ReservationListVO {
	
	private String hotelname;
	private String roomname;
	private String addr;
	private String cal;
	private Date checkin;
	private Date checkout;
	private int price;
	private double locX;
	private double locY;




	public ReservationListVO(String hotelname, String roomname, String addr, String cal, Date checkin, Date checkout,
			int price, double locX, double locY) {
		super();
		this.hotelname = hotelname;
		this.roomname = roomname;
		this.addr = addr;
		this.cal = cal;
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price;
		this.locX = locX;
		this.locY = locY;
	}



	public double getLocX() {
		return locX;
	}



	public void setLocX(double locX) {
		this.locX = locX;
	}



	public double getLocY() {
		return locY;
	}



	public void setLocY(double locY) {
		this.locY = locY;
	}



	public String getHotelname() {
		return hotelname;
	}



	public void setHotelname(String hotelname) {
		this.hotelname = hotelname;
	}



	public String getRoomname() {
		return roomname;
	}

	public void setRoomname(String roomname) {
		this.roomname = roomname;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getCal() {
		return cal;
	}

	public void setCal(String cal) {
		this.cal = cal;
	}

	public Date getCheckin() {
		return checkin;
	}

	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}

	public Date getCheckout() {
		return checkout;
	}

	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	

	
}
