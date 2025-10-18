package ch15;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
//Code15-1
//		String s1 = "スッキリJava";
//		String s2 = "Java";
//		String s3 = "java ";
//		if (s2.equals(s3)) {
//			System.out.println("s2とs3は等しい");
//		}
//		if (s2.equalsIgnoreCase(s3)) {
//			System.out.println("s2とs3はケースを区別しなければ等しい");
//		}
//		System.out.println("s1の長さは" + s1.length() + "です");
//		if (s1.isEmpty()) {
//			System.out.println("s1は空文字です");
//		}
//Code15-2
//		String s1 = "Java and JavaScript";
//		if (s1.contains("Java")) {
//			System.out.println("文字列s1は、Javaを含んでいます");
//		}
//		if (s1.endsWith("Java")) {
//			System.out.println("文字列s1は、Javaが末尾にあります");
//		}
//		System.out.println("文字列s1で最初にJavaが登場する位置は" + s1.indexOf("Java"));
//		System.out.println("文字列s1で最後にJavaが登場する位置は" + s1.lastIndexOf("Java"));
//Code15-3	
		String s1 = "Java programming";
		System.out.println("文字列s1の4文字名以降は" + s1.substring(3));
		System.out.println("文字列s1の4～8文字目以降は" + s1.substring(3,8));
	}
}
