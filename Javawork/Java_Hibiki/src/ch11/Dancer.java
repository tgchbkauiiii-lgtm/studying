package ch11;

public class Dancer extends Character {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	//フィールド
	//コンストラクタ
	public Dancer(String name) {
		this.name = name;
	}
	//メソッド
	public void dance() {
		s(this.name + "は情熱的に踊った");
	}
	public void attack(Matango m) {
		s(this.name + "の攻撃");
		s("敵に3ポイントのダメージ");
		m.hp -= 3;
	}
}
