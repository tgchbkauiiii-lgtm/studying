package ch10;

public class Matango {
	//フィールド
	int hp;
	final int LEVEL = 10;
	char suffix;
	//コンストラクタ
	//メソッド
	public void run() {
		ch06.Sleep.showDisplay("お化けキノコ" + this.suffix + "は逃げ出した！");
	}
}
