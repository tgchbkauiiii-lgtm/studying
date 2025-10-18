package ch15;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class simpleDateFormat {

	public static void main(String[] args) throws ParseException {
		// TODO 自動生成されたメソッド・スタブ
		SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d = f.parse("2023/09/18 05:53:20");
		System.out.println(d);
		Date now = new Date();
		String s = f.format(now);
		System.out.println("現在は" + s + "です");
	}

}
