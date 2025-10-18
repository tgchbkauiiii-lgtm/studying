package ch13;

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
	public abstract void attack(Monster m);
	
	//getter
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
	
	//setter
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException
			("名前がnullである。処理を中断");
		}
		if(name.length() <= 1) {
			throw new IllegalArgumentException
			("名前が短すぎる。処理を中断。");
		}
		if(name.length() >= 8) {
			throw new IllegalArgumentException
			("名前が長すぎる。処理を中断。");
		}
		this.name = name;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public void setItems(Item[] items) {
		this.items = items;
	}
	public void setW(Weapon w) {
		this.w = w;
	}
}
