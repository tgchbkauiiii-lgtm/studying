package ch05;

public class Code5_11 {
	public static int add(int x, int y) {
		return x + y;
	}
	public static int add(int x, int y, int z) {
		return x + y + z;
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("足し算したい値を入力してください。値1：");
		int x = new java.util.Scanner(System.in).nextInt();
		System.out.println("足し算したい値を入力してください。値2：");
		int y = new java.util.Scanner(System.in).nextInt();
		System.out.println("足し算したい値を入力してください。値3：");
		int z = new java.util.Scanner(System.in).nextInt();
		System.out.println(x + "+" + y + "=" + add(x,y));
		System.out.println(x + "+" + y + "+" + z + "=" + add(x,y,z));
	}

}
