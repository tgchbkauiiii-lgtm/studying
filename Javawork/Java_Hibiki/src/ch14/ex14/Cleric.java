package ch14.ex14;

public class Cleric {
	String name;
	int hp = 50;
	private static final int maxHp = 50;
	int mp = 10;
	private static final int maxMp = 10;
	
	public void selfAid()  {
		this.mp -= 5;
		this.hp = this.maxHp;
		ch06.Sleep.showDisplay("聖職者" + this.name + "は、\"セルフエイド\"を唱えた！");
		ch06.Sleep.showDisplay("MPを5消費してHPを全回復した");
	}
	public int pray(int seconds) {
		int beforeMp = this.mp;
		int vonus = new java.util.Random().nextInt(3);
		this.mp = this.mp + seconds + vonus;
		if (this.mp > this.maxMp) {
			this.mp = this.maxMp; 
		}
		int afterMp = this.mp;
		int delta = afterMp - beforeMp;
		ch06.Sleep.showDisplay("聖職者" + this.name + "は、" + seconds + "秒間祈った！");
		ch06.Sleep.showDisplay(this.name + "はMPを" + delta + "回復した");
		
		return delta;
	}
}
