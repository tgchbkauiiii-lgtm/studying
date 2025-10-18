package ch10.ex10_3;

public class Matango {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	//フィールド
	int hp = 50;
	char suffix;
	//コンストラクタ
	public Matango(char suffix) {
		this.suffix = suffix;
	}
	//メソッド
	public void attack(Hero h) {
		s("キノコ" + this.suffix + "の攻撃");
		s("10のダメージ");
		h.hp -= 10;
	}
	public void run() {
		s("お化けキノコ" + this.suffix + "は逃げ出した！");
	}
}