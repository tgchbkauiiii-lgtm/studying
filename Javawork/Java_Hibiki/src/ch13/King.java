package ch13;

public class King extends Character {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	public King(String name, int hp) {
		super(name, hp);
	}
	public King(String name) {
		super(name, 100);
	}
	
	void talk (Hero h) {
		s("ようこそ我が国へ,勇者" + h.getName() + "よ。");
	}
	@Override
	public void attack(Monster m) {
		// TODO 自動生成されたメソッド・スタブ
		s("王様は攻撃手段をもっていない！何もできなかった");
	}

}
