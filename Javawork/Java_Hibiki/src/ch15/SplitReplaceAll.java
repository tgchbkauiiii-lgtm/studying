package ch15;

public class SplitReplaceAll {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String s = "abc,def:ghi";
		String[] words = s.split("[,:]");
		for (String w : words) {
			System.out.print(w + "->");
		}
		System.out.print("\n");
		String a = s.replaceAll("[adg]","X");
		System.out.println(a);
	}

}
