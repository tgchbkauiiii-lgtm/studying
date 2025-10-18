package ch05;

public class Code5_14 {
	public static int[] makeArray(int size) {
		int[] newArray = new int[size];
		for (int i = 0; i < newArray.length; i++) {
			newArray[i] = i;
		}
		return newArray;
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int[] array = makeArray(3);
		for (int i : array) {
			System.out.println(i);
		}
	}

}
