package ch09;

public class Hero {
	//フィールド
	String name;
	int hp;
	Sword sword;
	
	//コンストラクタ
	public Hero(String name) {
		this.hp = 100;
		this.name = name;
	}
	public Hero() {
		this.hp = 100;
		this.name = "ダミー";
	}
	
	//メソッド
	public void sleep() {
		this.hp = 100;
		ch06.Sleep.showDisplay(this.name + "は、眠って回復した！");
	}
	public void sit(int sec) {
		this.hp += sec;
		ch06.Sleep.showDisplay(this.name + "は、" + sec + "秒座った！");
		ch06.Sleep.showDisplay("HPが" + sec + "ポイント回復した");
	}
	public void slip() {
		this.hp -= 5;
		ch06.Sleep.showDisplay(this.name + "は、転んだ！");
		ch06.Sleep.showDisplay("5のダメージ！");
	}
	public void run() {
		ch06.Sleep.showDisplay(this.name + "は、逃げ出した！");
		ch06.Sleep.showDisplay("GAMEOVER");
		ch06.Sleep.showDisplay("最終HPは" + this.hp + "でした");
	}
	public void attack() {
		ch06.Sleep.showDisplay(this.name + "は攻撃した！");
		ch06.Sleep.showDisplay("敵に5ポイントのダメージを与えた！");
	}
}
