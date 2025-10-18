package ch10.p10;

public class SuperHero extends Hero {
//フィールド
	boolean flying;
//コンストラクタ
	public SuperHero() {
		Sleep.showDisplay("SuperHeroのコンストラクタが動作");
	}
//メソッド
	public void fly() {
		this.flying=true;
		Sleep.showDisplay("飛び上がった！");
	}
	public void land() {
		this.flying=false;
		Sleep.showDisplay("着地した！");
	}
	@Override
	public void run() {
		Sleep.showDisplay(this.name+"は撤退した。");
	}
	@Override
	public void attack(Matango m) {
		super.attack(m);
		if(this.flying) {
			super.attack(m);
		}
	}
}
