package DB;

public class 소개VO {
	String foodid;
	String resname;
	int staraverage;
	String address;
	String tel;
	String restext;
	String resimg;
	String price;
	
	public String getFoodid() {
		return foodid;
	}
	public void setFoodid(String foodid) {
		this.foodid = foodid;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getResname() {
		return resname;
	}
	public void setResname(String resname) {
		this.resname = resname;
	}
	public int getStaraverage() {
		return staraverage;
	}
	public void setStaraverage(int staraverage) {
		this.staraverage = staraverage;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRestext() {
		return restext;
	}
	public void setRestext(String restext) {
		this.restext = restext;
	}
	public String getResimg() {
		return resimg;
	}
	public void setResimg(String resimg) {
		this.resimg = resimg;
	}
}
