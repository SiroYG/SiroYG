package model;

public class LocationVO {
	
	private String hotelName;
	private Double locationX;
	private Double locationY;
	public LocationVO(String hotelName, Double locationX, Double locationY) {
		super();
		this.hotelName = hotelName;
		this.locationX = locationX;
		this.locationY = locationY;
	}
	public String getHotelName() {
		return hotelName;
	}
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	public Double getLocationX() {
		return locationX;
	}
	public void setLocationX(Double locationX) {
		this.locationX = locationX;
	}
	public Double getLocationY() {
		return locationY;
	}
	public void setLocationY(Double locationY) {
		this.locationY = locationY;
	}
	
	
	
}
