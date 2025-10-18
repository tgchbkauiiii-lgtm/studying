package ch03;

public class squer {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.print("4～9の数字を入力してください＞");
		int num = new java.util.Scanner(System.in).nextInt();
	
		while (!((num > 3) && (num < 10))) {
			System.out.println("4～9て言っとるやろ。もう一回入力せい＞");
			num = new java.util.Scanner(System.in).nextInt();
		}
		
		for (int i = 1; i <= num; i++) {
			for (int j = 1; j <= num; j++) {
				if ((i == 1) || (i == num)) {
					System.out.print(num);
				} else if ((j == 1) || (j == num)) {
					System.out.print(num);
				} else {
					System.out.print("♡");
				}
			}
			System.out.println();
		}
	}
}
