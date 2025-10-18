package ch12;

public class Item {
	//フィールド
	String name;
	int price;
	//コンストラクタ
	public Item(String name) {
		this(name,0);
	}
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	//メソッド
}
