package ch15.ex15;

public class ex15_2 {

	public static void main(String[] args) {
		String folder = "c:\\javadev\\";
		String file = "readme.txt";
		String pass;
		if (folder.endsWith("\\")) {
			pass = folder + file;
			System.out.println("フォルダ名末尾に\\マークあり。そのまま連結。");
		} else {
			folder += "\\";
			pass = folder + file;
			System.out.println("フォルダ名末尾に\\マーク無し。付け足して連結。");
		}
		System.out.println(pass);
	}

}
