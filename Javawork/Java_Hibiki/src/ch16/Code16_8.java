package ch16;

import java.util.ArrayList;
import java.util.List;

public class Code16_8 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Hero h = new Hero();
		h.setName("ミナト");
		List<Hero> list = new ArrayList<>();
		list.add(h);
		h.setName("スガワラ");
		System.out.println(list.get(0).getName());
	}

}
