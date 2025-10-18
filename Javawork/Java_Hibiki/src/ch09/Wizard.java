package ch09;

public class Wizard {
	//フィールド
	String name;
	int hp;
	//コンストラクタ
	public Wizard(String name) {
		this.name = name;
	}
	public Wizard() {
		this("ダミー");
	}
	//メソッド
	public void heal(Hero h) {
		h.hp += 10;
		ch06.Sleep.showDisplay(h.name + "のHPを10回復した！");
	}
}
