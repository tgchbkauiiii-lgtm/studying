package ch15.ex15;

public class ex15_3 {

	public static void main(String[] args) {
		String s1 = "あほうごh";
		String s2 = "A7 ";
		String s3 = "UPOU";
		if (s1.matches("[a-zA-Z0-9あ-ん\\w\\s]")) {
			System.out.println("おK");
		} else {
			System.out.println("ちゃう");
		}
		if (s2.matches("A[0-9][0-9\s]")) {
			System.out.println("おK");
		} else {
			System.out.println("ちゃう");
		}
		if (s3.matches("U[A-Z]{3}")) {
			System.out.println("おK");
		} else {
			System.out.println("ちゃう");
		}
	}

}
