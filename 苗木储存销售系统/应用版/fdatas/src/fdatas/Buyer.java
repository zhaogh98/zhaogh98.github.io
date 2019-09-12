package fdatas;

public class Buyer {
	private String buyerID;
	private String buyername;
	private String company;
	private String phone;
	
	String getbuyerID(){
		return buyerID;
	}
	String getbuyername() {
		return buyername;
	}
	String getcompany() {
		return company;
	}
	String getphone() {
		return phone;
	}
	
	void setbuyerID(String a) {
		buyerID = a;
	}
	void setbuyername(String a) {
		buyername = a;
	}
	void setcompany(String a) {
		company = a;
	}
	void setphone(String a) {
		phone = a;
	}

}
