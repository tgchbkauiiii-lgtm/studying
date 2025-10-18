package ch05;

public class bigger3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		p("比較したい数値1を入力してください＞");
		int num1 = new java.util.Scanner(System.in).nextInt();
		p("比較したい数値2を入力してください＞");
		int num2 = new java.util.Scanner(System.in).nextInt();
		p("比較したい数値3を入力してください＞");
		int num3 = new java.util.Scanner(System.in).nextInt();
		bigger(num1,num2,num3);
	}
	public static void bigger(int num1,int num2,int num3) {
		int biggest = num1;
		if (num1 < num2) {
			biggest = num2;
		}
		if (biggest < num3) {
			biggest = num3;
		}
		p(num1 + "と" + num2 + "と" + num3 + "で一番大きいのは" + biggest);
	}
	public static void p(String str) {
		System.out.println(str);
	}

}
