package ch11;

public abstract class Character {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	//フィールド
	String name;
	int hp;
	//コンストラクタ
	//メソッド
	public void run() {
		s(this.name + "は逃げ出した");
	}
	public abstract void attack(Matango m);
}
