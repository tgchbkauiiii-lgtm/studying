package ch16;

import java.util.HashSet;
import java.util.Set;

public class Code16_3 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Set<String> colors = new HashSet<String>();
		colors.add("赤");
		colors.add("青");
		colors.add("黄");
		colors.add("赤");
		System.out.println("色は" + colors.size() + "種類");
	}

}
