package ch15;

public class PlayerName {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	public static boolean isValidPlayerName(String name) {
		return name.matches("[A-Z][A-Z0-9]{7}");
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		while (true) {
			System.out.println("名前を入力してください。8文字ちょうどで一文字目は\n必ず英字、残りの7文字は英数字で書いてください。\n>>");
			String name = new java.util.Scanner(System.in).nextLine();
			if (isValidPlayerName(name)) {
				s("条件を満たした名前です。名前を"+ name + "で登録しました。");
				break;
			} else {
				s("名前の条件を満たしていません。8文字ちょうどで一文字目\nは必ず英字、残りの7文字は英数字で書いてください。");
			}
		}
	}

}
