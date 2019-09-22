package model;

public class RoomVO {
	
	private String hotel_id;
	private String img1;
	private String img2;
	

	public RoomVO(String hotel_id, String img1, String img2) {
		super();
		this.hotel_id = hotel_id;
		this.img1 = img1;
		this.img2 = img2;
	}
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public String getImg2() {
		return img2;
	}
	public void setImg2(String img2) {
		this.img2 = img2;
	}
	
	
	
}
