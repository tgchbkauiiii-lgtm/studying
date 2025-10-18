package ch12.cat;

public class Cat {
//フィールド
	String species;//種族
	String name;
	int age;
	String favoriteFood;
//コンストラクタ
	public Cat(String species,String name,int age,String ff) {
		this.species=species;
		this.name=name;
		this.age=age;
		this.favoriteFood=ff;
	}
//メソッド
	public void introduction() {
		Sleep.showDisplay("僕は"+this.species+"の"+this.name);
		Sleep.showDisplay(this.age+"歳です。");
		Sleep.showDisplay("好きな食べ物は"+this.favoriteFood+"です。");
		Sleep.showDisplay("よろしくお願いしますにゃ。");
	}
}
