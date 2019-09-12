package fdatas;

import java.sql.Date;

public class Tree {
	private String treeID;
	private Date date;
	private String tree;
	private int size;
	private int num;
	private String tree_soil;
	private String source;
	private String field;
	private int on_truck;
	private int transport;
	private int off_truck;
	private int cost_price;
	private int sale_price;
	private String img;
	private String note;
	
	String gettreeID() {
		return treeID;
	}
	Date getdate() {
		return date;
	}
	String gettree() {
		return tree;
	}
	int getsize() {
		return size;
	}
	int getnum() {
		return num;
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
	int geton_truck() {
		return on_truck;
	}
	int gettransport() {
		return transport;
	}
	int getoff_truck() {
		return off_truck;
	}
	int getcost_price() {
		return cost_price;
	}
	int getsale_price() {
		return sale_price;
	}
	String getimg() {
		return img;
	}
	String getnote() {
		return note;
	}
	
	void settreeID(String a) {
		treeID = a;
	}
	void setdate(Date a) {
		date = a;
	}
	void settree(String a) {
		tree = a;
	}
	void setsize(int a) {
		size = a;
	}
	void setnum(int a) {
		num = a;
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
	void seton_truck(int a) {
		on_truck = a;
	}
	void settransport(int a) {
		transport = a;
	}
	void setoff_truck(int a) {
		off_truck = a;
	}
	void setcost_price(int a) {
		cost_price = a;
	}
	void setsale_price(int a) {
		sale_price = a;
	}
	void setimg(String a) {
		img = a;
	}
	void setnote(String a) {
		note = a;
	}
}
