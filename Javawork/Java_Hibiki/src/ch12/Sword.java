package ch12;

public class Sword extends Weapon {
	public Sword(int price, int damage) {
		super("勇者の剣",price);
		this.damage = damage;
	}
	public Sword(int damage) {
		super("勇者の剣",0);
		this.damage = damage;
	}
}
