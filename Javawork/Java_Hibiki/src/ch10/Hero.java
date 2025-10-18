package ch10;

public class Hero {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	//フィールド
	String name = "ミナト";
	int hp = 100;
	//コンストラクタ
	public Hero() {
		s("Heroのコンストラクタが動作");
	}
	//メソッド
	//戦う
	public void attack(Matango m) {
		s(this.name + "の攻撃!");
		m.hp -= 5;
		s("5ポイントのダメージを与えた！");
	}
	//逃げる
	public void run() {
		s(this.name + "は逃げ出した！");
	}
}
