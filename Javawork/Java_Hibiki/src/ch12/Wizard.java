package ch12;

public class Wizard extends Character {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	//フィールド
	int mp;
	//コンストラクタ
	public Wizard(String name, int hp, int mp) {
		super(name,hp);
		this.mp = mp;
	}
	public Wizard(String name, int hp) {
		this(name,hp,150);
	}
	public Wizard(String name) {
		this(name,20);
	}
	//メソッド
	public void run() {
		s(this.getName() + "は逃げ出した。");
	}
	public void attack(Monster m) {
		// TODO 自動生成されたメソッド・スタブ
		s(this.getName() + "の攻撃！");
		s("敵に1ポイントのダメージ");
		m.hp -= 1;
	}
	public void fireball(Monster m) {
		s(this.getName() + "は火の玉を放った！");
		s("敵に20ポイントのダメージ");
		m.hp -= 20;
		this.mp -= 5;
	}
}
