package ch12.cat;

public class Lion extends Cat {

	public Lion(String species, String name, int age, String ff) {
		super(species, name, age, ff);
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public void introduction() {
		Sleep.showDisplay("俺は"+this.species+"の"+this.name);
		Sleep.showDisplay(this.age+"歳だ。");
		Sleep.showDisplay("好きな食いもんは"+this.favoriteFood+"だぜ。");
		Sleep.showDisplay("夜露死苦");
	}
}
