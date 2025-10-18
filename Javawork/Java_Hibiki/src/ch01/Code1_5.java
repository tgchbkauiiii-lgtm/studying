package ch01;

public class Code1_5 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		final double PI = 3.14;
		int pie = 5;
		System.out.println("半径"+ pie + "cmのパイの面積は");
		System.out.println(pie * pie * PI);
		System.out.println("パイの半径を倍にします");
		pie = 10;
		//PI = 10; 再代入出来ない　しようとするとエラーになる
		System.out.println("半径" + pie + "cmのパイの面積は、");
		System.out.println(pie * pie * PI);
		
	}

}
