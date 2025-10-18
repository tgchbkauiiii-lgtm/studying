package ch10.ex10_3;

public class PoisonMatango extends Matango {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	//フィールド
	int PoisonCount = 5;
	//コンストラクタ
	public PoisonMatango(char suffix) {
		super(suffix);
	}
	//メソッド
	public void attack(Hero h) {
		super.attack(h);
		if(PoisonCount > 0) {
			s("さらに毒の胞子をばらまいた！");
			int damage = h.hp/5;
			h.hp -= damage;
			s(damage + "ポイントのダメージ！");
			PoisonCount--;
		}
		
	}
}
