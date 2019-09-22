package model;

public class HotelVO {
	
	private String hotel_id;
	private String hotel_name;
	private String hotel_room_name;
	private int price;
	private String info;
	private int c_person;
	private String category;
	private String location;
	private double location_x;
	private double location_y;
	private String cal;
	private String addr;
	private int score;
	private String img1;
	private String img2;
	private String hotel_title;
	private String img3;
	private String img4;
	public HotelVO(String hotel_id, String hotel_name, String hotel_room_name, int price, String info, int c_person,
			String category, String location, double location_x, double location_y, String cal, String addr, int score,
			String img1, String img2, String hotel_title, String img3, String img4) {
		super();
		this.hotel_id = hotel_id;
		this.hotel_name = hotel_name;
		this.hotel_room_name = hotel_room_name;
		this.price = price;
		this.info = info;
		this.c_person = c_person;
		this.category = category;
		this.location = location;
		this.location_x = location_x;
		this.location_y = location_y;
		this.cal = cal;
		this.addr = addr;
		this.score = score;
		this.img1 = img1;
		this.img2 = img2;
		this.hotel_title = hotel_title;
		this.img3 = img3;
		this.img4 = img4;
	}
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public String getHotel_name() {
		return hotel_name;
	}
	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}
	public String getHotel_room_name() {
		return hotel_room_name;
	}
	public void setHotel_room_name(String hotel_room_name) {
		this.hotel_room_name = hotel_room_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public int getC_person() {
		return c_person;
	}
	public void setC_person(int c_person) {
		this.c_person = c_person;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getLocation_x() {
		return location_x;
	}
	public void setLocation_x(double location_x) {
		this.location_x = location_x;
	}
	public double getLocation_y() {
		return location_y;
	}
	public void setLocation_y(double location_y) {
		this.location_y = location_y;
	}
	public String getCal() {
		return cal;
	}
	public void setCal(String cal) {
		this.cal = cal;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
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
	public String getHotel_title() {
		return hotel_title;
	}
	public void setHotel_title(String hotel_title) {
		this.hotel_title = hotel_title;
	}
	public String getImg3() {
		return img3;
	}
	public void setImg3(String img3) {
		this.img3 = img3;
	}
	public String getImg4() {
		return img4;
	}
	public void setImg4(String img4) {
		this.img4 = img4;
	}
	


}
