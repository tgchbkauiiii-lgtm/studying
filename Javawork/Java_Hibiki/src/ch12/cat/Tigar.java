package ch12.cat;

public class Tigar extends Cat {

	public Tigar(String species, String name, int age, String ff) {
		super(species, name, age, ff);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void introduction() {
		Sleep.showDisplay("私は"+this.species+"の"+this.name);
		Sleep.showDisplay(this.age+"歳ですわ。");
		Sleep.showDisplay("好物は"+this.favoriteFood+"ですの。");
		Sleep.showDisplay("よろしくお願いしますわ。");
	}

}
