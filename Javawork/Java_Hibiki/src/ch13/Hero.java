package ch13;

public class Hero extends Character {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	//フィールド
	//コンストラクタ
	public Hero(String name, int hp) {
		super(name,hp);
	}
	public Hero(String name) {
		super(name,100);
	}
	public Hero() {
		super("");
	}
	//メソッド
	//戦う
	public void getWeapon(Weapon w) {
		this.getWeapon();
		s(this.getName() + "は" + w.name + "を装備した。");
	}
	public void attack(Monster m) {
		if (this.getWeapon() != null) {
			s(this.getName() + "の攻撃!");
			m.hp -= 5 + this.getWeapon().damage;
			s(5+this.getWeapon().damage  + "ポイントのダメージを与えた！");
		} else {
			s(this.getName() + "の攻撃!");
			m.hp -= 5;
			s("5ポイントのダメージを与えた！");
		}
	}
}
