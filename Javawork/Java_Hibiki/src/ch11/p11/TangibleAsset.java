package ch11.p11;

public class TangibleAsset extends Asset {
//フィールド
	String color;
//コンストラクタ
	public TangibleAsset(String name,int price,String color) {
		super(name, price);
		this.color = color;
	}
//メソッド
	public String getColor() {
		return this.color;
	}
}
