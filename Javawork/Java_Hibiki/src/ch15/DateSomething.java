package ch15;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class DateSomething {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy/MM/dd");
		LocalDate ldate = LocalDate.parse("2023/09/22",fmt);
		
		LocalDate ldatep = ldate.plusDays(1000);
		String str = ldatep.format(fmt);
		System.out.println("1000日後は" + str);
		
		LocalDate now = LocalDate.now();
		if (now.isAfter(ldate)) {
			System.out.println("本日は、その日より未来です");
			
		LocalDate d1 = LocalDate.of(2023, 1, 1);
		LocalDate d2 = LocalDate.of(2023, 1, 4);
		
		Period p1 = Period.ofDays(3);
		Period p2 = Period.between(d1, d2);
		
		LocalDate d3 = d2.plus(p2);
		System.out.println(d1 + "と" + d2 + p1 + p2 + d3);
		}
	}

}
