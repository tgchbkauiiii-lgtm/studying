package ch14.ex14;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Account a1 = new Account();
		Account a2 = new Account();
		a1.accountNumber = "4587";
		a2.accountNumber = "4587  ";
		a1.balance = 100000;
		a2.balance = 926;
		System.out.println(a1.equals(a2.accountNumber));
		
		Cleric c = new Cleric();
		Cleric cc = new Cleric();
//		System.out.println(c.maxHp);
//		cc.maxHp = 1000;
//		System.out.println(c.maxHp);
	}

}
