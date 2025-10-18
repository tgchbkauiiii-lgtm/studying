package ch04;

public class ex4_4 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[] numbers = {3,4,9};
		System.out.print("1桁の数字を入力してください＞");
		int input = new java.util.Scanner(System.in).nextInt();
		for (int num : numbers) {
			if (num == input) {
				System.out.println("アタリ！");
			}
		}
	}

}
