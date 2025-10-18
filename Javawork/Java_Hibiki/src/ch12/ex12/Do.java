package ch12.ex12;

public class Do {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//練習12-2
		X obj = new A();
		obj.a(); 
//		obj.b(); obj.c();
		Y y1 = new A(); Y y2 = new B();
		y1.a(); y2.a();
		//練習12-3
		Y[] Ys = {
				new A(),
				new B()
		};
		for (Y y : Ys) {
			y.b();
		}
	}

}
