package ch03;

public class triangle {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.print("三角形の大きさを入力してください＞");
		int size = new java.util.Scanner(System.in).nextInt();
		for (int i = 1; i <= size; i++ ) {
			for (int j = 1; j <= i; j++) {
				System.out.print("▲");
			}
			System.out.print("\n");
		}
	}

}
