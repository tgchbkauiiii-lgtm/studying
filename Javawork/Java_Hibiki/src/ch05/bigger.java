package ch05;

public class bigger {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		p("比較したい数値1を入力してください＞");
		int num1 = new java.util.Scanner(System.in).nextInt();
		p("比較したい数値2を入力してください＞");
		int num2 = new java.util.Scanner(System.in).nextInt();
		bigger(num1,num2);
	}
	public static void bigger(int num1,int num2) {
		if (num1 > num2) {
			p(num1 + "と" + num2 + "で多いほうは:" + num1);
		} else {
			p(num1 + "と" + num2 + "で多いほうは:" + num2);
		}
	}
	public static void p(String str) {
		System.out.println(str);
	}
}
