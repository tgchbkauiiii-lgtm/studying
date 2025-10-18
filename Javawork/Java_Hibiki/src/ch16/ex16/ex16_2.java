package ch16.ex16;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import ch16.Hero;

public class ex16_2 {
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Hero h1 = new Hero("斎藤");
		Hero h2 = new Hero("鈴木");
		ArrayList<Hero> HeroList = new ArrayList<>();
		HeroList.add(h1);
		HeroList.add(h2);
		for (Hero h : HeroList) {
			System.out.println(h.getName());
		}
		Map<Hero,Integer> killCount = new LinkedHashMap<>();
		killCount.put(h1,3);
		killCount.put(h2,7);
		for (Hero h : killCount.keySet()) {
			System.out.println(h.getName() + "が倒した敵＝" + killCount.get(h));
		}
	}

}
