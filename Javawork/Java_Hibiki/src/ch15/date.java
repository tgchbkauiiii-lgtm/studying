package ch15;

import java.util.Date;

public class date {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Date now = new Date();
		System.out.println(now);
		System.out.println(now.getTime());
		Date past = new Date(1694984000000L);
		System.out.println(past);
	}

}
