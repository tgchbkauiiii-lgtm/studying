package ch10.ex10_3;

public class Main {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Hero h = new Hero();
		PoisonMatango pm = new PoisonMatango('A');
		while(true) {
			h.attack(pm);
			pm.attack(h);
			
			if(pm.hp <= 0) {
				s("勇者" + h.name + "はキノコ" + pm.suffix + "を倒した！");
				break;
			}
			if(h.hp <= 0) {
				s("おぉ勇者" + h.name + "よ。死んでしまうとは情けない！");
				break;
			}
			s("勇者" + h.name + "の残りHPは" + h.hp);
			s("キノコ" + pm.suffix + "の残りHPは" + pm.hp);
			s("-----------------------------");
		}
//		SuperHero sh = new SuperHero();
//		Hero h = new Hero();
//		h.run();
//		SuperHero sh = new SuperHero();
//		sh.run();
//		Matango m = new Matango();
//		sh.fly();
//		sh.attack(m);
//		sh.land();
	}

}