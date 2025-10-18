package ch11.ex11;

public class Main {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Book b = new Book("ｽｯｷﾘJava",1500,"緑","フレアリンク");
		Computer c = new Computer("hp laptop",200000,"白","hp");
		s("当社は有形資産として");
		s(b.getIsbn() + "発行の" + b.getColor() + "色の" + b.getPrice() + "円する" + b.getName() + "\nという書籍を所有しています。重さは" + b.getWeight() + "gです。");
		s(c.getMakerName() + "発行の" + c.getColor() + "色の" + c.getPrice() + "円する" + c.getName() + "\nというPCを所有しています。重さは" + c.getWeight() + "gです。");
	}

}
