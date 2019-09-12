package fdatas;

import java.util.Date;

public class Money {
	private int moneynum;
	private Date date;
	private int pay;
	private int get;
	
	int getmoneynum() {
		return moneynum;
	}
	Date getdate() {
		return date;
	}
	int getpay() {
		return pay;
	}
	int getget() {
		return get;
	}
	
	void setmoneynum(int a) {
		moneynum = a;
	}
	void setdate(Date a) {
		date = a;
	}
	void setpay(int a) {
		pay = a;
	}
	void setget(int a) {
		get = a;
	}

}
