package ch17;

public class ex17_1 {

	public static void main(String[] args) {
		try {
			String s = null;
			System.out.println(s.length());
		} catch (Exception e) {
			System.out.println("NullPointerExceptio例外をキャッチしました");
			System.out.println("--スタックトレース(ここから)--");
			e.printStackTrace();
			System.out.println("--スタックトレース(ここまで)--");
		}
		
	}

}
