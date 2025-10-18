package ch10.p10;

public class Matango {
//フィールド
	int hp = 50;
	char suffix;
//コンストラクタ
	public Matango(char suffix) {
		this.suffix=suffix;
	}
//メソッド
	public void attack(Hero h) {
		Sleep.showDisplay("キノコ"+this.suffix+"の攻撃");
		Sleep.showDisplay("10のダメージ");
		h.hp-=10;
	}
	public void run() {
		Sleep.showDisplay("お化けキノコ"+this.suffix+"は逃げ出した！");
	}
}
