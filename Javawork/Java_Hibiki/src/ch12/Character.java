package ch12;

public abstract class Character {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	//フィールド
	private String name;
	private int hp;
	private Item[] items;
	private Weapon w;
	//コンストラクタ
	public Character(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}
	public Character(String name) {
		this(name,100);
	}
	//メソッド
	public void run() {
		s(this.name + "は逃げ出した");
	}
	public String getName() {
		return this.name;
	}
	public int getHp() {
		return this.hp;
	}
	public Item[] getItems() {
		return this.items;
	}
	public Weapon getWeapon() {
		return this.w;
	}
	public abstract void attack(Monster m);
}
