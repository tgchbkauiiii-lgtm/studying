package ch05;

public class ex5_2 {
	public static void email(String title, String address, String text) {
		System.out.println(address+"に、以下のメールを送信しました");
		System.out.println("件名:"+title);
		System.out.println("本文:"+text);
	}
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		String title = "明日の会議について";
		String address = "asagi@java.sukkiri";
		String text = "明日の会議ですが、予定の会議室が使えなくなりましたので場所を変更して402号室で行いたいと思います";
		
		email(title,address,text);
	}

}
