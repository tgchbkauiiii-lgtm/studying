package ch17;

public class Ex17_3 {

	public static void main(String[] args) {
		try {
			int i = Integer.parseInt("三");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("引数が正しくありません。再入力してください。>>");
			new java.util.Scanner(System.in).nextLine();
		}
	}

}
