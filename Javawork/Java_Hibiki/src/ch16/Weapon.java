package ch16;

public class Weapon extends Item {
	int damage;
	public Weapon(String name, int price) {
		super(name,price);
	}
	public Weapon(String name) {
		super(name,0);
	}
}
