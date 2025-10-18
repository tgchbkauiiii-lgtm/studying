package ch13;

public class Slime extends Monster {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	int hp = 35;
	public void run() {
		s("スライムはサササっと逃げ出した。");
	}
}
