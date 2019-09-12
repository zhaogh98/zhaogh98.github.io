package fdatas;

import java.sql.Date;

public class Trade {
	private int salenum;
	private Date date;
	private String buyername;
	private String company;
	private String tree;
	private int size;
	private int wantnum;
	private String tree_soil;
	private String source;
	private String field;
	private int out_price;
	private String note;
	
	int getsalenum() {
		return salenum;
	}
	Date getdate() {
		return date;
	}
	String getbuyername() {
		return buyername;
	}
	String getcompany() {
		return company;
	}
	String gettree() {
		return tree;
	}
	int getsize() {
		return size;
	}
	int getwantnum() {
		return wantnum;
	}
	String gettree_soil() {
		return tree_soil;
	}
	String getsource() {
		return source;
	}
	String getfield() {
		return field;
	}
	int getout_price(){
		return out_price;
	}
	String getnote() {
		return note;
	}
	
	void setsalenum(int a) {
		salenum = a;
	}
	void setdate(Date a) {
		date = a;
	}
	void setbuyername(String a) {
		buyername = a;
	}
	void setcompany(String a) {
		company = a;
	}
	void settree(String a) {
		tree = a;
	}
	void setsize(int a) {
		size = a;
	}
	void setwantnum(int a) {
		wantnum = a;
	}
	void settree_soil(String a) {
		tree_soil = a;
	}
	void setsource(String a) {
		source = a;
	}
	void setfield(String a) {
		field = a;
	}
	void setout_price(int a) {
		out_price = a;
	}
	void setnote(String a) {
		note = a;
	}

}
