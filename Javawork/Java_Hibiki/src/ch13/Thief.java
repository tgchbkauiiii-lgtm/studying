package ch13;

public class Thief extends Character {
	//フィールド
	private int mp;
	//コンストラクタ
	public Thief(String name, int hp, int mp) {
		super(name,hp);
		this.mp = mp;
	}
	public Thief(String name, int hp) {
		this(name,hp,5);
	}
	public Thief(String name) {
		this(name,40);
	}
	//メソッド
	public void attack(Monster m) {
		s(this.getName() + "の攻撃!");
		m.hp -= 4;
		s("4ポイントのダメージを与えた！");
	}
}
