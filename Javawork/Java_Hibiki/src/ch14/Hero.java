package ch14;

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
		super("名無し");
	}
	//メソッド
	public void getWeapon(Weapon w) {
		this.getWeapon();
		s(this.getName() + "は" + w.name + "を装備した。");
	}
	public static void setRandomMoney() {
		Hero.setMoney((int)(Math.random() * 1000));
	}
	@Override
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
	@Override
	public String toString() {
		return "名前:" + this.getName() + "/HP:" + this.getHp();
	}
	@Override
	public boolean equals(Object o) {
		if (this == o) {return true;}
		if (o instanceof Hero h) {
			if (this.getName().equals(h.getName())) {
				return true;
			}
		}
		return false;
		
	}
	public static void setMoney(int money) {
		Hero.setMoney(money);
	}
	public static int getMoney() {
		return getMoney();
	}
}
