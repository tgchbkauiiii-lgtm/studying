package ch12.cat;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Cat[] cats = {
			new Cat("猫","たま",3,"マグロ"),
			new Lion("ライオン","キング",5,"シマウマ"),
			new Tigar("虎","アンソワ",15,"人間")
		};
		for(Cat c:cats)
			c.introduction();
	}

}
