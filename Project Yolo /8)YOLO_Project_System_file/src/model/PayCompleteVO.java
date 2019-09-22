package model;

public class PayCompleteVO {
	
	private String id;
	private String hotelid;
	private String checkin;
	private String checkout;
	private int price;
	public PayCompleteVO(String id, String hotelid, String checkin, String checkout, int price) {
		super();
		this.id = id;
		this.hotelid = hotelid;
		this.checkin = checkin;
		this.checkout = checkout;
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getHotelid() {
		return hotelid;
	}
	public void setHotelid(String hotelid) {
		this.hotelid = hotelid;
	}
	public String getCheckin() {
		return checkin;
	}
	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}
	public String getCheckout() {
		return checkout;
	}
	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
	

}
