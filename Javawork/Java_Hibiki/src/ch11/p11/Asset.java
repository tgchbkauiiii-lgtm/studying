package ch11.p11;

public class Asset {
//フィールド
	String name;
	int price;
//コンストラクタ
	public Asset(String name,int price) {
		this.name=name;
		this.price=price;
	}
//メソッド
	public String getName() {
		return this.name;
	}
	public int getPrice() {
		return this.price;
	}
}
