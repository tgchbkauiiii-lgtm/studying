package ch14.ex14;

public class Account {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	static String accountNumber;
	static int balance;
	
	public String toString() {
		return "\\" + this.balance + "(口座番号:" + this.accountNumber + ")";
	}
	public boolean equals(String s) {
		if (this.accountNumber == s) {return true;}
		if (this.accountNumber.trim().equals(s)) {
			return true;
		}
		return false;
		
	}
}
