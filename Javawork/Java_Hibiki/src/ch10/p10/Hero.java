package ch10.p10;

public class Hero {
//フィールド
	String name = "ミナト";
	int hp = 100;
//コンストラクタ
	public Hero() {
		Sleep.showDisplay("Heroのコンストラクタが動作");
	}
//メソッド
	public void attack(Matango m) {
		Sleep.showDisplay(this.name+"の攻撃！");
		m.hp-=5;
		Sleep.showDisplay("5ポイントのダメージをあたえた！");
	}
	public void run() {
		Sleep.showDisplay(this.name+"は逃げ出した！");
	}
}
