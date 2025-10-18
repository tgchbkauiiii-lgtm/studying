package ch03;

public class building {
	public static void main(String[] args) {
		System.out.print("1階ごとの部屋数＞");
		int room = new java.util.Scanner(System.in).nextInt();
		System.out.print("階数＞");
		int floor = new java.util.Scanner(System.in).nextInt();
		System.out.print("窓を開ける階＞");
		int open = new java.util.Scanner(System.in).nextInt();
		for (int i = 0; i < floor; i++) {
			for (int j = 1; j <= room; j++) {
				if (open == (floor - i)) {
					System.out.print("□");
				}else {
					System.out.print("■");
				}
			}
			System.out.println("");
		}
	}
}
