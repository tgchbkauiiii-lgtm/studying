package ch12.cat;

public class Sleep {
	public static void showDisplay(Object o){
		String str = o.toString();//オブジェクト型のtoStringの値を抽出
		char[] chars = str.toCharArray();//char型配列に変換
		for(char c:chars) {//1文字づつ取り出す。
			System.out.print(c);//1文字表示
			try {//例外処理
				Thread.sleep(100);//0.1秒待つ
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();//例外が発生したらエラーを表示
			}
		}
		System.out.print("\n");//改行
	}
	//オーバーロードして秒数を調整出来るようにしてあります。
	public static void showDisplay(Object o,int sec){
		String str = o.toString();
		char[] chars = str.toCharArray();
		for(char c:chars) {
			System.out.print(c);
			try {
				Thread.sleep(sec*1000);
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
		}
		System.out.print("\n");
	}
}
