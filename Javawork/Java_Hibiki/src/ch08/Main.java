package ch08;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//勇者を生成
		Hero h = new Hero();
		
		//フィールドに初期値を設定
		h.name = "ミナト";
		h.hp = 100;
		
		Matango m1  = new Matango();
		m1.hp = 50;
		m1.suffix = 'A';
		
		Matango m2  = new Matango();
		m2.hp = 48;
		m2.suffix = 'B';
		
		Cleric c = new Cleric();
		c.name = "エリス";
		
//		h.slip();
//		m1.run();
//		m2.run();0
//		h.run();
		c.selfAid();
		c.pray(1);
	}

}
