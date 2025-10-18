package ch10.p10;

public class Main {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		SuperHero sh = new SuperHero();
		PoisonMatango pm = new PoisonMatango('A');
		//sh.fly();
		while(true) {
			statusView(sh,pm);
			sh.attack(pm);
			pm.attack(sh);
			//死亡処理
			if(sh.hp<=0 || pm.hp<=0)break;
		}
		Sleep.showDisplay("***::: Result :::***");
		statusView(sh,pm);
	}
	public static void statusView(SuperHero h,PoisonMatango m) {
		Sleep.showDisplay("+----- Status -----+");
		Sleep.showDisplay(h.name+"のHP:"+h.hp);
		Sleep.showDisplay("マタンゴ"+m.suffix+"のHP:"+m.hp);
		Sleep.showDisplay("+----- ****** -----+");
	}
}
