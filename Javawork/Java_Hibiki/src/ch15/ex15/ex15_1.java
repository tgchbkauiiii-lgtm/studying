package ch15.ex15;

public class ex15_1 {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		String s;
		for (int i = 1; i <= 100; i++) {
			sb.append(i + ",");
		}
		s = sb.toString();
		System.out.println(s);
		String[] a = s.split(",");
		for (String A : a) {
			System.out.print(A + " ");
		}
	}

}
