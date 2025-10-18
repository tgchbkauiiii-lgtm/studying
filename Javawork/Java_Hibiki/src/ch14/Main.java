package ch14;

public class Main {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
//		Empty e = new Empty();
//		String s = e.toString();
//		s(s);
//		Hero h1 = new Hero("ミナト");
//		String hs = h1.toString();
//		s(h1);
		
//		Hero h2 = new Hero("ミナト");
//		s(h2);
//		if (h1.equals(h2) == true) {
//			s("同じ内容です");
//		} else {
//			s("違う内容です");
//		}
//		Hero.setMoney(100);
//		s(Hero.getMoney());
//		s(h1.getMoney());
//		h1.setMoney(300);
//		s(h2.getMoney());
		Hero.setRandomMoney();
		s(Hero.getMoney());
		Hero h1 = new Hero();
		s(h1.getMoney());
	}

}
