package ch10.p10;

public class PoisonMatango extends Matango {
//フィールド
	int ponson;
//コンストラクタ
	public PoisonMatango(char suffix) {
		super(suffix);
		// TODO 自動生成されたコンストラクター・スタブ
		this.ponson=5;
	}
//メソッド
	@Override
	public void attack(Hero h) {
		super.attack(h);
		if(this.ponson>0) {
			Sleep.showDisplay("さらに毒の胞子をばらまいた！");
			int damage = h.hp/5;
			h.hp-=damage;
			Sleep.showDisplay(damage+"のダメージ");
			this.ponson--;
		}
	}
}
