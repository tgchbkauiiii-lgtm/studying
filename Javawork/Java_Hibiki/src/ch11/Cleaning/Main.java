package ch11.Cleaning;

public class Main {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		KyotoCleaningShop kcs = new KyotoCleaningShop();
		Shirt s = new Shirt("佐伯イッテツ",'L',"紫");
		Towel t = new Towel("樋口楓","フェイス","白");
		Coat c = new Coat("アンジュカトリーナ","ダッフル","赤");
		
		kcs.washShirt(s);
		kcs.washTowel(t);
		kcs.washCoat(c);
	}

}
