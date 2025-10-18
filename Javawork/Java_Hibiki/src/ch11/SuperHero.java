package ch11;

public class SuperHero extends Hero {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	//フィールド
	boolean flying;
	//コンストラクタ
	public SuperHero() {
		s("SuperHeroのコンストラクタが動作");
	}
	//メソッド
	public void attack(Matango m) {
		super.attack(m);
		if (this.flying) {
			super.attack(m);
		}
	}
	public void fly() {
		this.flying = true;
		s("飛び上がった！");
	}
	public void land() {
		this.flying = false;
		s("着地した！");
	}
	@Override
	public void run() {
		s(this.name + "は撤退した");
	}
}
