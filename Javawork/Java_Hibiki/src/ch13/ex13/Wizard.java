package ch13.ex13;

import ch13.Hero;

public class Wizard {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	//フィールド
	private int hp;
	private int mp;
	private String name;
	private Wand wand;
	
	//メソッド
	void heal(Hero h) {
		int basePoint = 10;
		int recoverPoint = (int)(basePoint * this.wand.getPower());
		h.setHp(h.getHp() + recoverPoint);
		s(h.getName() + "のHPを" + recoverPoint + "回復した！");
	}
	//setter
	public void setHp(int hp) {
		if (hp < 0) {
			s("HPは0以上にしてください。\n0未満の値を入力すると自動的に0になります。");
			hp = 0;
		}
		this.hp = hp;
	}

	public void setMp(int mp) {
		if (mp < 0) {
			throw new IllegalArgumentException
			("MPは0以上にしてください。");
		}
		this.mp = mp;
	}

	public void setName(String name) {
		if (name.length() < 3) {
			throw new IllegalArgumentException
			("魔法使いの名前は3文字以上にしてください。");
		}
		this.name = name;
	}

	public void setWand(Wand wand) {
		if (wand == null) {
			throw new IllegalArgumentException
			("魔法使いには必ず杖を持たせてください。");
		}
		this.wand = wand;
	}
	
	//getter
	public int getHp() {
		return hp;
	}
	public int getMp() {
		return mp;
	}
	public String getName() {
		return name;
	}
	public Wand getWand() {
		return wand;
	}
}
