package ch13;

public class Main {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	public static void main(String[] args) {
		Hero h = new Hero("まさひこ");
		Wizard wz = new Wizard("あさみ");
		Slime slime = new Slime();
		Goblin goblin = new Goblin();
		Weapon w = new Weapon("剣");
		DeathBat db = new DeathBat();
		h.attack(slime);
		slime.run();
		h.getWeapon(w);
		h.attack(goblin);
		slime.run();
		h.attack(slime);
		goblin.run();
		wz.fireball(db);
		db.run();
	}
}













//k.talk(h);
//h.setName("あああああああああああああああ");
//monsters[0] = new Slime();
//Monster[] monsters = new Monster[3];
//monsters[0] = new Slime();
//monsters[1] = new Goblin();
//monsters[2] = new DeathBat();
//for (Monster m : monsters) {
//	m.run();
//}
//Character[] c = new Character[5];
//c[0] = new Hero("マツダ");
//c[1] = new Hero("ショウタ");
//c[2] = new Thief("アサカ");
//c[3] = new Wizard("タグチ");
//c[4] = new Wizard("ヒビキ");
//
////宿に泊まる
//for (Character ch : c) {
//	ch.hp += 50;
//	s(ch.name + "のHPは回復して" + ch.hp + "になった");
//}
//Slime s = new Slime();
//Monster m = new Slime();
//s.run(); 
//m.run();
//Wizard w = new Wizard();
//Character c = w;
//Matango m = new Matango();
////w.name = "アサカ";
////w.attack(m);
////w.fireball(m);
//c.name = "アサカ";
//c.attack(m);
//Wizard cw = (Wizard) c;
//cw.fireball(m);