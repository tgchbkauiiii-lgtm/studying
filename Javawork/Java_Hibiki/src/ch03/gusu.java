package ch03;

public class gusu {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.print("1～100までの偶数の合計は:");
		int sum = 0;
		for (int i = 2; i <= 100; i += 2) {
			sum += i;
		}
		System.out.print(sum);
	}

}
