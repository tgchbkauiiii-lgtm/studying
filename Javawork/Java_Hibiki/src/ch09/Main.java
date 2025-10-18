package ch09;

import ch06.Sleep;

public class Main {

	public static void heal(int hp) {
		hp += 10;
	}
	public static void heal(Thief thief) {
		thief.hp += 10;
	}
	
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int baseHp = 25;
		Thief t = new Thief("アサカ",baseHp);
		heal(baseHp);
		Sleep.showDisplay(baseHp + ":" + t.hp);
		heal(t);
		Sleep.showDisplay(baseHp + ":" + t.hp);
//		Sword s = new Sword();
//		s.name = "炎の剣";
//		s.damage = 10;
//		Hero h1 = new Hero("ミナト");
//		Hero h2 = new Hero();
//		Wizard w = new Wizard("スガワラ");
//		w.hp = 50;
//		w.heal(h1);
//		w.heal(h2);
//		w.heal(h2);
		
//		Sleep.showDisplay(h1.name + "のHPは" + h1.hp);
//		Sleep.showDisplay(h2.name + "のHPは" + h2.hp);
//		Sleep.showDisplay(w.name + "のHPは" + w.hp);
	
	}

}
