package ch14;

public abstract class Monster {
	public static void s(Object o) {
		ch06.Sleep.showDisplay(o);
	}
	int hp;
	public void run() {
		s("モンスターは逃げ出した。");
	}
}
